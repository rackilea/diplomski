val injector = Guice.createInjector(new ScalaModule {
  override def configure(): Unit = {
    bindPlugin[MyPlugin]()
    bindPlugin[OtherPlugin]()

    bind[PluginManager].asEagerSingleton()
  }

  def bindPlugin[T <: Plugin : Manifest](): Unit = {
    val plugins = ScalaMultibinder.newSetBinder[Plugin.Factory[T]](binder)
    plugins.addBinding().to[Plugin.Factory[T]]
    bindFactory[Plugin, T, Plugin.Factory[T]]()
  }

  def bindFactory[I: Manifest, C <: I : Manifest, F: Manifest](): Unit = {
    import net.codingwell.scalaguice._
    install(new FactoryModuleBuilder()
      .implement(typeLiteral[I], typeLiteral[C])
      .build(typeLiteral[F]))
  }
})