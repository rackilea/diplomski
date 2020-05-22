private void runOnWebView (View view, WebViewAction action) {
    if (view instanceof WebView){
        action.run((WebView)view);
        return;
    }

    if (view instanceof ViewGroup) {
        final ViewGroup parent = (ViewGroup)view;

        for (int i = 0; i < parent.getChildCount(); i++) {
            runOnWebView(parent.getChildAt(i), action);
        }
    }
}

private interface WebViewAction{
    void run(WebView view);
}