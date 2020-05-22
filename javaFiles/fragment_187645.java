class GlobalContext @Inject()(playInjector: Injector) {
  GlobalContext.injectorRef = playInjector
}

object GlobalContext {
  private var injectorRef: Injector = _

  def injector: Injector = injectorRef
}