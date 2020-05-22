WebViewClient webViewClient= new WebViewClient(){
@Override
public boolean shouldOverrideUrlLoading(WebView  view, String  url){
    return true;
}
@Override
public void onLoadResource(WebView  view, String  url){
    try {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    } catch (ActivityNotFoundException ignored) {
    }
  }
}