public abstract class AbstractListener {

   public abstract void eventEnd();
   public abstract boolean callMyExtraMethod();

   public void templateMethod(){
    if(callMyExtraMethod()){
        eventEnd();
    }
  }
}