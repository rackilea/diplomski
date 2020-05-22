@Override
public void onBackPressed()
{
    if(WebView.canGoBack()){
        WebView.goBack();
    }else{
        super.onBackPressed();
    }
}