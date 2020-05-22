class Worker extends SwingWorker<Void, String> {

    @Override
    protected Void doInBackground() throws Exception {
       //here you make heavy task this is running in another thread not in EDT


      return null;
    }

   @Override
   protected void done() {
        //this is executed in the EDT            
   }
}