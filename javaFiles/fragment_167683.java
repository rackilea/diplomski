webView.evaluateJavascript("globalJavascriptFunction();", new ValueCallback<String>() {
    @Override
    public void onReceiveValue(String result) { 
       // result is the return value of globalJavascriptFunction()
       // you'll have to do some testing inside here to figure out exactly how result gets sent back for your usecase
    }
});