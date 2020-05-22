String strTempURI = "https://" + serverName + "/exchange/" + Username
        + "/drafts/" +strSubject + "eml";
String strSubURI = "https://" + serverName + "/exchange/" + Username
        + "/##DavMailSubmissionURI##/";

URI uri=new URI(strTempURI);
HttpPut put = new HttpPut(uri);
ByteArrayEntity entity = new ByteArrayEntity(byteout1);
DefaultHttpClient client =new DefaultHttpClient();
HttpContext localContext = new BasicHttpContext();
CredentialsProvider credsProvider = new BasicCredentialsProvider();
credsProvider.setCredentials(new AuthScope(AuthScope.ANY_HOST,    
              AuthScope.ANY_PORT,AuthScope.ANY_REALM, AuthPolicy.BASIC),
            new UsernamePasswordCredentials(Username, password));

client.setCredentialsProvider(credsProvider);
put.setHeader("Content-Type", "message/rfc822");
put.setEntity(entity);
localContext.setAttribute(ClientContext.CREDS_PROVIDER, credsProvider);
HttpResponse response=client.execute(put,localContext);
HttpEntity resEntity = response.getEntity();
String result = EntityUtils.toString(resEntity);

 MoveMethod move = new MoveMethod(uri.toString(), strSubURI);
        move.setHeader("Destination", strSubURI);
        HttpResponse status = client.execute(move);