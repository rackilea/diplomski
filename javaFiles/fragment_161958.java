webView.setWebChromeClient(new WebChromeClient()  
    {  

        //The undocumented magic method override  
           //Eclipse will swear at you if you try to put @Override here  
        // For Android 3.0+
        public void openFileChooser(ValueCallback<Uri> uploadMsg) {  
            Intent i = new Intent(Intent.ACTION_GET_CONTENT);  
            i.addCategory(Intent.CATEGORY_OPENABLE);  
            i.setType("image/*");  
            startActivityForResult(Intent.createChooser(i,"File Chooser"), 222);  
           }

        // For Android 3.0+
           public void openFileChooser( ValueCallback uploadMsg, String acceptType ) {
//           Intent i = new Intent(Intent.ACTION_GET_CONTENT);
           i.addCategory(Intent.CATEGORY_OPENABLE);
           i.setType("*/*");
           startActivityForResult(
           Intent.createChooser(i, "File Browser"),
           222);
           }

        //For Android 4.1
           public void openFileChooser(ValueCallback<Uri> uploadMsg, String acceptType, String capture){
//               openFileChooser(uploadMsg);
               Intent i = new Intent(Intent.ACTION_GET_CONTENT);  
               i.addCategory(Intent.CATEGORY_OPENABLE);  
               i.setType("image/*");  
               startActivityForResult( Intent.createChooser( i, "File Chooser" ), 2223 );

           }

    });