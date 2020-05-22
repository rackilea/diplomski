@Override
public void onBackPressed()
{
    WebView webView = (WebView) findViewById(R.id.webView1);
    if(webView.canGoBack()){
        webView.goBack();
    }else{
        super.onBackPressed();
    }
}