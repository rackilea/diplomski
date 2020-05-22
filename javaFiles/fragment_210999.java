((WebView)findViewById(R.id.yourwebviewId)).loadUrl(Url); 
//or
 ((WebView)findViewById(R.id.yourwebviewId)).loadData(yourhtmlstring, "text/html", "UTF-8"); 

//or safer 
 WebView web=(WebView)findViewById(R.id.yourwebviewId);
 if(web!=null) web.LoadUrl(..)