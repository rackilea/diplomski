private void getManyFromServer2(final int numberOfGets) {
  new SwingWorker<Void, String>() {
     @Override
     protected Void doInBackground() throws Exception {
        try {
           for (int i = 0; i < numberOfGets; i++) {

              fromServer = sockIn.readLine();
              fromServer += "\n";
              // textArea.append(fromServer);
              publish(fromServer);
           }
        } catch (IOException exc) {
           exc.printStackTrace();
        }
        return null;
     }

     @Override
     protected void process(List<String> chunks) {
        for (String line : chunks) {
           textArea.append(line);
        }
     }

     @Override
     protected void done() {
        try {
           get();
        } catch (InterruptedException | ExecutionException e) {
           e.printStackTrace();
        }
     }
  }.execute();
}