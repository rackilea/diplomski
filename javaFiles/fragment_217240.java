public static void copy(InputStream input, OutputStream output)
    throws IOException {
   byte[] buffer = new byte[16 * 1024]; // For example...
   int bytesRead;
   while ((bytesRead = input.read(buffer)) > 0) {
     output.write(buffer, 0, bytesRead);
   }
}