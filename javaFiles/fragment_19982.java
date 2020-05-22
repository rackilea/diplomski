URL url = new URL( "http://google.com:666/" );
HttpURLConnection httpConn =  (HttpURLConnection)url.openConnection();
httpConn.setInstanceFollowRedirects( false );
httpConn.setRequestMethod( "HEAD" ); 
try{
    httpConn.connect();
     System.out.println( "google.com : " + httpConn.getResponseCode());
}catch(java.net.ConnectException e){
     System.out.println( "google.com:666 is down ");
}