abstract class A {
   private void checkInvariant(){
       //check state
       //if state is breaking invariant throw exception
   }

   public void doSth() {
        checkInvariant();
        doActualWork();
        checkInvariant();
   }

   protected abstract void doActualWork();
}