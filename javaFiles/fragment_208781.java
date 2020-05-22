URL url = new URL(urlString);
// open the connection
URLConnection con = url.openConnection();
// get and verify the header field
String fieldValue = con.getHeaderField("Content-Disposition");
if (fieldValue == null || ! fieldValue.contains("filename=\"")) {
  // no file name there -> throw exception ...
}
// parse the file name from the header field
String filename = fieldValue.substring(fieldValue.indexOf("filename=\"") + 10, fieldValue.length() - 1);
// create file in systems temporary directory
File download = new File(System.getProperty("java.io.tmpdir"), filename);

// open the stream and download
ReadableByteChannel rbc = Channels.newChannel(con.getInputStream());
FileOutputStream fos = new FileOutputStream(download);
try {
  fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
} finally {
  fos.close();
}