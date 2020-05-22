public class SomeClass {
  void doSomething() {
    Map<String,String> mapProps = ... ;
    Injector injector = Guice.createInjector(new MyInjector(mapProps));
    Config someConfig = injector.getInstance(Config.class);          
  }
}