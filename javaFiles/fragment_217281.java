if(isOnline(getApplicationContext()){
    webview.loadUrl("http://the.url.com")
}
else{
    Toast.makeText(context, text, duration).show()
}