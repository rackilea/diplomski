class createGUI extends SwingWorker<Void, Void>
{
  private Thread startTimer;
  public createGUI(Thread startTimer) {
    this.startTimer = startTimer;
  }
  @Override
  protected Integer doInBackground() throws Exception {
     //Some long processing
  }

  @Override
  protected void done()
  {
     //Doing GUI work here
     prgBar.setInderminent(false);
     startTimer.start();
  }
}