URLConnection con = new URL( url ).openConnection();
System.out.println( "orignal url: " + con.getURL() );
con.connect();
System.out.println( "connected url: " + con.getURL() );
InputStream is = con.getInputStream();
System.out.println( "redirected url: " + con.getURL() );
is.close();