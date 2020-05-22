class RetrieveFeedTask extends AsyncTask<Void, Void, String> {

    private Exception exception;

    protected String doInBackground(Void... params) {

        try {
            List<String> scopes = new ArrayList<String>();
            scopes.add(StorageScopes.DEVSTORAGE_FULL_CONTROL);
              httpTransport= new com.google.api.client.http.javanet.NetHttpTransport();


              //agarro la key y la convierto en un file
              AssetManager am = getAssets();
              String STORAGE_SCOPE = "https://www.google.com/analytics/feeds/" ;
              InputStream inputStream = am.open("*********114db0.p12"); //you should not put the key in assets in prod version.



              //convert key into class File. from inputstream to file. in an aux class.
              File file =stream2file(inputStream);


              //Google Credentianls
              GoogleCredential credential = new GoogleCredential.Builder().setTransport(httpTransport)
                      .setJsonFactory(JSON_FACTORY)
                      .setServiceAccountId("**********ic1bgevf3h@developer.gserviceaccount.com")
                      .setServiceAccountScopes((scopes))
                      .setServiceAccountPrivateKeyFromP12File(file)
                      .build();




              String URI = "https://storage.googleapis.com/" + "BUCKET_NAME"+"/"+"zzzzz3"+".jpg";
              HttpRequestFactory requestFactory = httpTransport.createRequestFactory(credential);


              GenericUrl url = new GenericUrl(URI);




              //byte array holds the data, in this case the image i want to upload in bytes.

              Resources res = getResources();
              Drawable drawable = res.getDrawable(R.drawable.camera);
              Bitmap bitmap = ((BitmapDrawable)drawable).getBitmap();
              ByteArrayOutputStream stream = new ByteArrayOutputStream();
              bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
              byte[] bitMapData = stream.toByteArray();


            HttpContent contentsend = new ByteArrayContent("image/jpeg", bitMapData );


              HttpRequest putRequest;

                putRequest = requestFactory.buildPutRequest(url, contentsend);




              com.google.api.client.http.HttpResponse response = putRequest.execute();
              String content = response.parseAsString();
              Log.d("debug", "response is:"+response.getStatusCode());
              Log.d("debug", "response content is:"+content);
            } catch (IOException | GeneralSecurityException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        return "";

    }

    protected void onPostExecute(String feed) {
        int i  = 0;
        int j = i;
        // TODO: check this.exception 
        // TODO: do something with the feed
    }
}