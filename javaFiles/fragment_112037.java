URL url = new URL(urlString);
HttpURLConnection cnx = (HttpURLConnection)url.openConnection();
cnx.setRequestMethod("PUT");
cnx.setRequestProperty("Content-Type", "application/octet-stream");
// optional request property
cnx.setRequestProperty("filename", filename);
cnx.setDoOutput(true);
cnx.connect();
BufferedInputStream fileIn = 
       new BufferedInputStream(new FileInputStream(fileName), BUFFER_SIZE);
BufferedOutputStream out = 
       new BufferedOutputStream(cnx.getOutputStream(), BUFFER_SIZE);
byte[] bytes = new byte[BUFFER_SIZE];
int bytesRead;
while((bytesRead = fileIn.read(bytes)) != -1){
   out.write(bytes, 0, bytesRead);
}