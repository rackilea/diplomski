JSONArray imageObj = directory.getJSONArray(TAG_IMG); 
 JSONObject img = imageObj.getJSONObject(0);
 String imageURL = img.getString("NewTAG");
  //then
 ImageView imagePhoto = (ImageView) findViewById(R.id.photo);    
 ImageLoader imgLoader = new ImageLoader(getApplicationContext());        
 imgLoader.DisplayImage(imageURL, imagePhoto);