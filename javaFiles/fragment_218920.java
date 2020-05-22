public void myMethod() {
  final MyProgessBarFrame progFrame = new MyProgessBarFrame();
  new SwingWorker<Void, Void>() {
     protected Void doInBackground() throws Exception {

        // do some processing here while the progress bar is running
        // .....
        return null;
     };

     // this is called when the SwingWorker's doInBackground finishes
     protected void done() {
        progFrame.setVisible(false); // hide my progress bar JFrame
     };
  }.execute();
  progFrame.setVisible(true);
}