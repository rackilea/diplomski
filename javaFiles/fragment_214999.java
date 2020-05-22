object.getMessageXml(someRequestString, new AsyncCallback<String>() {
  @Override
  public void onFailure(Throwable caught) {
    // Handle error.
  }

  @Override
  public void onSuccess(String messageXml) {
    // Process response
  }
});