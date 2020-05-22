try {
  //try to open page in facebook native app.
  String uri = "fb://page/" + yourFBpageId;    //Cutsom URL
  Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
  startActivity(intent);   
  }
  catch (ActivityNotFoundException ex){
  //facebook native app isn't available, use browser.
  String uri = "http://touch.facebook.com/pages/x/" + yourFBpageId;  //Normal URL  
  Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(uriMobile));    
  startActivity(i); 
  }