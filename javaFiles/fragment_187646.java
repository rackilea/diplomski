object Toyota extends Car {

  import GlobalContext.injector

  // at this point Guice figures out how to instantiate MyClass, create and inject all the required dependencies
  val myClass = injector.instanceOf[MyClass]

  ...

}