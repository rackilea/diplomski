try {
   File file = new File(Environment.getExternalStorageDirectory(),"FMS_photo.jpg");

   HttpClient client = new DefaultHttpClient();  
   HttpPost post = new HttpPost("http://homepage.com/path");  
   FileBody bin = new FileBody(file);  


   Charset chars = Charset.forName("UTF-8");

   MultipartEntity reqEntity = new MultipartEntity();  
   reqEntity.addPart("problem[photos_attributes][0][image]", bin);  
   reqEntity.addPart("myString", new StringBody("17", chars));

   post.setEntity(reqEntity); 
   HttpResponse response = client.execute(post);  

   HttpEntity resEntity = response.getEntity();  
   if (resEntity != null) {    
     resEntity.consumeContent();  
  }

   return true;

  } catch (Exception ex) {

    globalStatus = UPLOAD_ERROR;
    serverResponse = "";
    return false;
  } finally {

 }