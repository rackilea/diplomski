class MyJavascriptBridge { 

   public void caller() {
     //now you know you are on the right place (chat.html)
     webView.loadUrl("javascript:openDialog()"); 
   }
 }