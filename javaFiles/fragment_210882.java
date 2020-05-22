MultipartEntityBuilder builder = MultipartEntityBuilder.create();
 builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);

 File file = new File("/sample.jpg");
 FileBody filebody = new FileBody(file);
 builder.addPart("image", filebody );
 builder.addTextBody("type", "file");
 builder.addTextBody("album", '<Deleted hash>' );    //anonymous album

 HttpEntity entity = builder.build();

 HttpPost httpPost = new HttpPost("<Imgur API endpoint>");
 httpPost.setEntity( entity );

 CloseableHttpClient httpClient = HttpClientBuilder.create().build()
 HttpResponse response = httpClient.execute( httpPost );