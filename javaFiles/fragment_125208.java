private Document doc;
 ...
 SwingWorker<Document, Void> worker = new SwingWorker<Document, Void>() {
   @Override
   public Document doInBackground() {
      // any action you want to perform in backgroud
      // i.e. in separate thread
   }
   @Override
   public void done() {
     try {
        // called after background thread is finished
     } catch (InterruptedException ex) {
       ex.printStackTrace();
     } catch (ExecutionException ex) {
       ex.printStackTrace();
     }
   }
 }