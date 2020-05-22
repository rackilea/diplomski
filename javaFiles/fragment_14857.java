WebView myWebView;


 this.myWebView = (WebView) findViewById(R.id.myWebView);

  @Override
    public void onBackPressed()
    {
        if(myWebView.canGoBack()){
            myWebView.goBack();
        }else{
            super.onBackPressed();
        }
    }