public class C extends A {
   @Override
   public D createBInstance() {
       return new D(); //forgot parenthesis 
   }
}