InputStream input = Filer.readImage("images/test.jpg");
byte[] buffer = new byte[1024];
int bytesRead;
while ((bytesRead = input.read(buffer)) != -1) {
    responseBody.write(buffer, 0, bytesRead);
}
responseBody.close(); // <-----------