URL website = new URL("http://www.website.com/information.asp");
URLConnection connection = website.openConnection();
ReadableByteChannel rbc = Channels.newChannel( connection.getInputStream());
FileOutputStream fos = new FileOutputStream("information.html" );
long expectedSize = connection.getContentLength();
System.out.println( "Expected size: " + expectedSize );
long transferedSize = 0L;
while( transferedSize < expectedSize ) {
   transferedSize +=
      fos.getChannel().transferFrom( rbc, transferedSize, 1 << 24 );
   System.out.println( transferedSize + " bytes received" );
}
fos.close();