mAdView.setAdListener(new AdListener(){
    @Override
    public void onAdLoaded(){
        runOnWebView(mAdView, new WebViewAction(){
            @Override
            public void run(WebView view){
                view.setLayerType(View.LAYER_TYPE_HARDWARE, null);
                view.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
            }
        });
    }
});