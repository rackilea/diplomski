String payload = "";
  Element e = DOM.getElementById("form");
  // you need make this recursive if you want grand-children
  for (int i = 0, l = e.getChildCount(); i < l; i++) {
    Element c = e.getChild(i).cast();
    if (c.getTagName().toLowerCase().matches("input")) {
      String name = c.<InputElement>cast().getName();
      String value = c.<InputElement>cast().getValue();
      payload += name + "=" + value + "&";
    }
  }

  RequestBuilder b = new RequestBuilder(POST, "/my_servlet");
  try {
    b.sendRequest(payload, new RequestCallback() {
      public void onResponseReceived(Request request, Response response) {
         String resp = response.getText();
      }
      public void onError(Request request, Throwable exception) {
      }
    });
  } catch (RequestException ex) {
    ex.printStackTrace();
  }