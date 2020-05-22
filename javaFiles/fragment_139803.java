HttpClient httpclient = new DefaultHttpClient();
HttpPost postRequest = new HttpPost(ServiceURL);
try {
    MultipartEntity reqEntity = new MultipartEntity();

    reqEntity.addPart("email", new StringBody("test@testmail.com"));
    reqEntity.addPart("password", new StringBody("123"));
    reqEntity.addPart("title", new StringBody("My new song"));
    reqEntity.addPart("musicData", new FileBody(new File(FilePath)));     
    postRequest.setEntity(reqEntity);

    HttpResponse response = httpclient.execute(postRequest);

} catch (URISyntaxException e) {
    Log.e("URISyntaxException", e.toString());
}