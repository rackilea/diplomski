_webView.setWebViewClient(new WebViewClient(){
@Override
public boolean shouldOverrideUrlLoading(WebView view, String url) {
            //find out if the link we're looking for is really for this app
    if (url.contains("myapp://activity")){
        String action= = url.substring("myapp://activity/?".length());
        //parse the action from the link...
        //do something with this action..., parse additional params etc.

        return true;
    }

    //handle the "normal" links...
    return super.shouldOverrideUrlLoading(view, url);
}   
});