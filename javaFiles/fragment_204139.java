public String getResponse(String connUrl, String xml) {
    DefaultHttpClient httpClient = null;
    try {
        MultipartEntity mp = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE);
        HttpPost method = new HttpPost(connUrl);
        method.setEntity(mp);
        mp.addPart("xml_request", new StringBody(xml));

        httpClient = new DefaultHttpClient();
        HttpResponse response = httpClient.execute(method);

        if(response.getStatusLine().getStatusCode() == 200){
            ByteArrayOutputStream outstream = new ByteArrayOutputStream();
            response.getEntity().writeTo(outstream);
            return outstream.toString();
        }
    }
    catch(Exception e) {
        Log.v("APP", "Exception while create connection for getResponse from server with: " + e.getMessage());
    }
    finally {
        httpClient.getConnectionManager().shutdown();
    }
    return "";
}