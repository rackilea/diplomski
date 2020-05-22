try {
         HttpClient client = new DefaultHttpClient();
     HttpPost post = new HttpPost(Image_url);
     MultipartEntity mpEntity = new MultipartEntity();
     File file = new File(selectedImagePath);
     ContentBody cbFile = new FileBody(file, "image/jpeg");         
     mpEntity.addPart("photo", cbFile);
     mpEntity.addPart("user_id", new StringBody(SmallyTaxiTabbar.unique_ID));
     mpEntity.addPart("password", new StringBody(SmallyTaxiTabbar.password));
     post.setEntity(mpEntity);
     HttpResponse response1 = client.execute(post);
     HttpEntity resEntity = response1.getEntity();
     String Response=EntityUtils.toString(resEntity);
     Log.d("PICTUREServer Response", Response);
     JSONArray jsonarray = new JSONArray("["+Response+"]");
     JSONObject jsonobject = jsonarray.getJSONObject(0);
     alert=(jsonobject.getString("alert"));
     client.getConnectionManager().shutdown();
    } 
     catch (Exception e) {
                Log.e("TAGPost", e.toString());     
    }