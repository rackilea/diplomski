activity.runOnUiThread(new Runnable() {
  @Override
  public void run() {
    Toast.makeText(...).show();
  }
});