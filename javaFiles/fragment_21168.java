public class Bar {

   private Set<Foo> foos;

   public Bar addFoo( Foo foo ) {
     this.foos.add( foo );
     return this;
   }
}