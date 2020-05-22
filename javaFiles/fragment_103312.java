private void searchForPattern(java.awt.event.ActionEvent evt) {
  textArea.setText("");
  busyLabel.setText("Searching ...");
  new SwingWorker<Void, Void>() {
     @Override
     protected Void doInBackground() throws Exception {
        doSearch();
        return null;
     }

     @Override
     protected void done() {
        busyLabel.setText("Idle");
     }
  }.execute();
}