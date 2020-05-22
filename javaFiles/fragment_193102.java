public static long copyLarge(InputStream input, OutputStream output)
       throws IOException {
   byte[] buffer = new byte[DEFAULT_BUFFER_SIZE];
   long count = 0;
   int n = 0;
   while ((n = input.read(buffer))>=0) {
       output.write(buffer, 0, n);
       count += n;
   }
   return count;