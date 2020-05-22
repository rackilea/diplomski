@Override
public void onPageFinished(WebView view, String url) {
    view.loadUrl("javascript: window.APPLICATION.setMyFunction = function(func){"
        + "window.APPLICATION.setMyFunctionAsString(func.toString());"
        + "};");
    super.onPageFinished(view, url);
}