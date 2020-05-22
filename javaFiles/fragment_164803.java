abstract class A {
   public void doSth(){
       Invariant invariant = getInvariant();
       check(invariant);
       //do some work
       check(invariant);
   }

   //define your invariant in concrete impl
   protected abstract Invariant getInvariant();
}