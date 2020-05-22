public class NormalClass {
   private ActivityName activity;

   public NormalClass(ActivityName activity){
      this.activity = activity;
   }

   public void doSomething()
   {
      activity.getBlipComp();
   }
}