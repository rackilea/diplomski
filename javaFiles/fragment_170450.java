`String removeHeader = "javascript:document.getElementById('page_header').remove();";
if (Build.VERSION.SDK_INT >= 19) {
        webView.evaluateJavascript(script, callback);

} else
    webView.loadUrl(script, null);`