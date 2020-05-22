URL url = new URL( "http://google.com/" );
HttpURLConnection conn = (HttpURLConnection) url.openConnection();
if( conn.getResponseCode() == HttpURLConnection.HTTP_OK ){
    InputStream is = conn.getInputStream();
    // do something with the data here
}else{
    InputStream err = conn.getErrorStream();
    // err may have useful information.. but could be null see javadocs for more information
}