class FooAction{

   @Inject private FooFactory fooFactory;

   doFoo(){
      // Send bar details through the Factory, not the "injector" 
      Foo f = fooFactory.create("This foo is named bar. How lovely!");
      f.getFooName(); // "This foo is named bar. How lovely!"
   }
}