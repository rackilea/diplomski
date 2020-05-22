BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

String line = reader.readLine();
StringBuilder buffer = new StringBuilder();
while ( line != null) {
   buffer.append(line);
   line = reader.readLine();

   // you can check here if the line is empty and decide only to read the header
   // or to split your header and body into different buffers

}
String fullText = buffer.toString();