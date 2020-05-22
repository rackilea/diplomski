URL url = new URL( "http://google.com/" );
HttpURLConnection httpConn =  (HttpURLConnection)url.openConnection();
httpConn.setInstanceFollowRedirects( false );
httpConn.setRequestMethod( "HEAD" ); 
httpConn.connect();

System.out.println( "google.com : " + httpConn.getResponseCode());