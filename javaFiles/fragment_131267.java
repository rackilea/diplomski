object Test {
  trait Plugin {
    def name(): String
  }

  object Plugin {
    trait Factory[+T <: Plugin] {
      def newPlugin(name: String): T
    }
  }

  case class MyPlugin @Inject() (@Assisted name: String) extends Plugin
  case class OtherPlugin @Inject() (@Assisted name: String) extends Plugin

  class PluginManager @Inject() (pluginFactories: Set[Plugin.Factory[Plugin]]) {
    for (factory <- pluginFactories) {
      println(factory.newPlugin("assisted injection"))
    }
  }

  def main(args: Array[String]): Unit = {
    val injector = Guice.createInjector(new ScalaModule {
      override def configure(): Unit = {
        val plugins = ScalaMultibinder.newSetBinder[Plugin.Factory[Plugin]](binder)
        plugins.addBinding().to[Plugin.Factory[MyPlugin]]
        plugins.addBinding().to[Plugin.Factory[OtherPlugin]]

        bindFactory[Plugin, MyPlugin, Plugin.Factory[MyPlugin]]()
        bindFactory[Plugin, OtherPlugin, Plugin.Factory[OtherPlugin]]()

        bind[PluginManager].asEagerSingleton()
      }

      def bindFactory[I: Manifest, C <: I : Manifest, F: Manifest](): Unit = {
        import net.codingwell.scalaguice._
        install(new FactoryModuleBuilder()
          .implement(typeLiteral[I], typeLiteral[C])
          .build(typeLiteral[F]))
      }
    })
  }
}