public class MyWorker extends SwingWorker<Integer, Integer> {
   private OtherClass otherClass;

   public MyWorker() {
      otherClass = new OtherClass(this);
   }

   @Override
   protected Integer doInBackground() throws Exception {
      otherClass.otherMethod();
      return null;
   }

   // public method that exposes setProgress
   public void publicSetProgress(int prog) {
      setProgress(prog);
   }

}