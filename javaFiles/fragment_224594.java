class OtherClass {
   MyWorker myWorker;

   public OtherClass(MyWorker myWorker) {
      this.myWorker = myWorker;
   }

   public void otherMethod() {
      for (int i = 0; i < 100; i++) {
         myWorker.publicSetProgress(i);
         try {
            Thread.sleep(200);
         } catch (InterruptedException e) {}
      }
   }
}