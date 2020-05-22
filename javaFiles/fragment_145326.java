activity.runOnUiThread(new Runnable() { // EDIT: ...Ui... requires a lowercase "i"
  @Override 
  public final void run()
     // this runs on UI thread
     activity.ttsUtteranceComplete(); // this function will run on the UI thread
  }
});