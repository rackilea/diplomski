StringEntity entity = new StringEntity(json.toString());
                     entity.setContentType("application/json;charset=UTF-8");
                     entity.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE,"application/json;charset=UTF-8"));
                     request.setHeader("Accept", "application/json");
                     request.setEntity(entity); 

                     HttpResponse response =null;
                     DefaultHttpClient httpClient = new DefaultHttpClient();

                     HttpConnectionParams.setSoTimeout(httpClient.getParams(), Constants.ANDROID_CONNECTION_TIMEOUT*1000); 
                     HttpConnectionParams.setConnectionTimeout(httpClient.getParams(),Constants.ANDROID_CONNECTION_TIMEOUT*1000); 
                     try{

                     response = httpClient.execute(request); 
                     }
                     catch(SocketException se)
                     {
                         Log.e("SocketException", se+"");
                         throw se;
                     }




InputStream in = response.getEntity().getContent();
BufferedReader reader = new BufferedReader(new InputStreamReader(in));
String line = null;
while((line = reader.readLine()) != null){
    sb.append(line);