HttpClient client = new DefaultHttpClient();
    client.getParams().setParameter(CoreProtocolPNames.PROTOCOL_VERSION, HttpVersion.HTTP_1_1);     
    HttpPost    post   = new HttpPost( "http://localhost:8080/service/uploadFile"));
    MultipartEntity entity = new MultipartEntity( HttpMultipartMode.BROWSER_COMPATIBLE );
    StringBody size= new StringBody("50x50");
    entity.addPart("smallSize", size);
    entity.addPart("file", new FileBody(new File("D:/abc.txt") ));
    post.setEntity(entity);

    HttpResponse response = client.execute(post);
    String responseFromServer = EntityUtils.toString(response.getEntity(), "UTF-8" );
    client.getConnectionManager().shutdown();
    System.out.println("response from server: "+responseFromServer);