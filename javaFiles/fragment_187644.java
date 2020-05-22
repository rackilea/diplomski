class InjectionModule extends AbstractModule {
  override def configure() = {
    // ...
    bind(classOf[MyClass])
    bind(classOf[GlobalContext]).asEagerSingleton()
  }
}