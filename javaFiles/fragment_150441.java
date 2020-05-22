//@SomeXMLAnnotations
public class Derived1 extends Base {

   //@AnyAnnoations..
   public Foo getFoo() { 
       return this.foo 
   }

   protected Foo setFoo(Foo foo) { 
       this.foo = foo; 
   }
}