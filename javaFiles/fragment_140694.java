file.add(new AjaxEventBehavior("fileuploaddone") {
  @Override
  protected void onEvent(AjaxRequestTarget target) {
    // Wait until behavior has completed.
    synchronized (fileUploadBehavior) {
      // TODO Add proper components to `target`.
    }
  }
});