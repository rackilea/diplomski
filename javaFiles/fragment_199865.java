binderModule implements Module{

 void configure(Binder binder) {
   binder.install(new FactoryModuleBuilder()
         .implement(FooInterface.class, Foo.class)
         .build(FooFactory.class));
 }
}