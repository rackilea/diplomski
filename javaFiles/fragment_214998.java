public void getMessageXml(String requestData,
                          final AsyncCallback<String> callback) {
  try {
    // Modify for your application.
    RequestBuilder rb = new RequestBuilder(Method.GET,
      "http://www.mycompany.com/getMessageXml");

    rb.sendRequest(requestData, new RequestCallback() {
      @Override
      public void onError(Request request, Throwable caught) {
        callback.onFailure(caught);
      }

      @Override
      public void onResponseReceived(Request request, Response response) {
        if (Response.SC_OK == response.getStatusCode()) {
          callback.onSuccess(response.getText());
        } else {
          // Use a correctly typed exception here.
          callback.onFailure(...);
        }
      }
    });
  } catch (RequestException rex) {
    callback.onFailure(rex);
  }
}