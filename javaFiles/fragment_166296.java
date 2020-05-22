@Override  
public boolean shouldOverrideUrlLoading(WebView view, String url) {  
        // TODO Auto-generated method stub  
       web.loadUrl(url);  
       return true;  
}