myView.post(new Runnable() {
  @Override
  public void run() {
    myView.invalidate();
  }
});