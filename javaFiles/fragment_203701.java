GWT.setUncaughtExceptionHandler(new GWT.UncaughtExceptionHandler() {
  @Override 
  public void onUncaughtException(Throwable e) {
    GWT.log(e.getMessage(), e); 
  }
});