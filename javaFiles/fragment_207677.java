new LoadHandler() {
  HandlerRegistration reg = image.addLoadHandler(this);

  @Override
  public void onLoad(LoadEvent evt) {
    reg.removeHandler();
    // Reset style
  }
}