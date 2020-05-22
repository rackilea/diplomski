WebView web = (WebView) findViewById(R.id.webview);

web = new WebView(this);  
web.getSettings().setJavaScriptEnabled(true);
web.loadUrl("http://www.yoururl.com/index.html");
web.setWebViewClient(new myWebClient());
web.setWebChromeClient(new WebChromeClient()  
{  
       //The undocumented magic method override  
       //Eclipse will swear at you if you try to put @Override here  
    // For Android 3.0+
    public void openFileChooser(ValueCallback<Uri> uploadMsg) {  

        mUploadMessage = uploadMsg;  
        Intent i = new Intent(Intent.ACTION_GET_CONTENT);  
        i.addCategory(Intent.CATEGORY_OPENABLE);  
        i.setType("image/*");  
        MyWb.this.startActivityForResult(Intent.createChooser(i,"File Chooser"), FILECHOOSER_RESULTCODE);  

       }

    // For Android 3.0+
       public void openFileChooser( ValueCallback uploadMsg, String acceptType ) {
       mUploadMessage = uploadMsg;
       Intent i = new Intent(Intent.ACTION_GET_CONTENT);
       i.addCategory(Intent.CATEGORY_OPENABLE);
       i.setType("*/*");
       MyWb.this.startActivityForResult(
       Intent.createChooser(i, "File Browser"),
       FILECHOOSER_RESULTCODE);
       }

    //For Android 4.1
       public void openFileChooser(ValueCallback<Uri> uploadMsg, String acceptType, String capture){
           mUploadMessage = uploadMsg;  
           Intent i = new Intent(Intent.ACTION_GET_CONTENT);  
           i.addCategory(Intent.CATEGORY_OPENABLE);  
           i.setType("image/*");  
           MyWb.this.startActivityForResult( Intent.createChooser( i, "File Chooser" ), MyWb.FILECHOOSER_RESULTCODE );

       }

});  


setContentView(web);