private String callback;

public void getImage(String callback) {
    this.callback = callback;
    // Call a thread or an asynchronous object such as AsyncTask
    // The thread or the AsyncTask should call the method callbackJavascript
    // to send the answer back
}

public void callbackJavascript(String result) {
     mWebView.loadUrl("javascript:window." + this.callback + "(" + result + ");");
}