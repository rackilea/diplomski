SwingWorker worker = new SwingWorker<Void, Void>() {

   @Override
   protected Void doInBackground() throws Exception {
      doHeavyLoop();
      return null;
   }
};