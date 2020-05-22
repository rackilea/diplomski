public void exit()
{
   Platform.runLater( new Runnable(){@Override public void run(){
      System.err.println( "exit/runLater/run" );
      webEngine.getLoadWorker().cancel();
      Platform.exit();
      SwingUtilities.invokeLater( new Runnable(){ @Override public void run() {
         System.err.println( "exit/invokeLater/run" );
         frame.dispose(); }});
      }});
}