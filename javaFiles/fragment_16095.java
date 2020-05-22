File file = new File("/root/images/test.gif");
arg0.sendResponseHeaders(200, file.length());
// TODO set the Content-Type header to image/gif 

OutputStream outputStream=arg0.getResponseBody();
Files.copy(file.toPath(), outputStream);
outputStream.close();