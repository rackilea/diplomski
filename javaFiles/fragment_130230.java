mWebView.setWebViewClient(new WebViewClient() {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
        @Override
        public void onPageStarted (WebView view, String url, Bitmap favicon){
            String jsScript= "javascript:var functions_array = ['testNativeMethod'];";
                   jsScript+="var jsinterface = {};"
                   jsScript+="functions_array.map(function(id){"
                   jsScript+="jsinterface[id]= function() {"
                   jsScript+="try{return temp_obj[id].apply(temp_obj, arguments);}"
                   jsScript+="catch(e) { console.log('ERROR: ' + e + ', method ' + id);"
                   jsScript+="return false;}}})"
            view.loadUrl(jsScript);
        }
    });