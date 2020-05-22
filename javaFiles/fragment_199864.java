class Foo implements FooInterface {
   String bar;

   @Inject
   Foo(@Assisted String bar)
   {
      this.bar = bar;
   }

   // return the final name
   getFooName(){
     return this.bar;
   }

}