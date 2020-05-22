@Override
public void onBackPressed()
        {
            WebView webView = (WebView) findViewById(R.id.webView); // Remove this
            if(webView.canGoBack()){
                webView.goBack();
            }else{
                super.onBackPressed();
            }
      }

}