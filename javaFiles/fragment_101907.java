Override 
public boolean onKeyDown(int keyCode, KeyEvent event) {
    if ((keyCode == KeyEvent.KEYCODE_BACK) && webView.canGoBack()) { 

        //if Back key pressed and this WebView has a back history item.
        webView.goBack(); 
        return true; 
     } 
  return super.onKeyDown(keyCode, event);
}