HttpClient client = new DefaultHttpClient();
client.getParams().setParameter(CoreProtocolPNames.PROTOCOL_VERSION,HttpVersion.HTTP_1_1);
HttpPost post = new HttpPost( url );
MultipartEntity entity = new MultipartEntity( HttpMultipartMode.BROWSER_COMPATIBLE );
// For File parameters
entity.addPart( paramName, new FileBody((( File ) paramValue ), "application/zip" ));
// For usual String parameters
entity.addPart( paramName, new StringBody( paramValue.toString(), "text/plain", Charset.forName( "UTF-8" )));
post.setEntity( entity );
// Here we go!
String response = EntityUtils.toString( client.execute( post ).getEntity(), "UTF-8" );
client.getConnectionManager().shutdown();