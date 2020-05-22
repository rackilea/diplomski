mWebView.setWebViewClient(new WebViewClient(){

public boolean shouldOverrideUrlLoading(Webview view, String url){
     if(url.endsWith(".mp4") || url.endsWith("some other supported type")){
          Intent i = new Intent(Intent.ACTION_VIEW);
          i.setData(Uri.parse(url));
          startActivity(i); //warning no error handling will cause force close if no media player on phone.
          return true;
     }
     else return false; 
}});