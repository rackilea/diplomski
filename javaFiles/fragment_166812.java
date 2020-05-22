OutputStream out = null;
InputStream in = null;
try {
   out = /* some output stream */;
   in = new java.util.GZIPInputStream(/*some stream*/);
   byte[] buffer = new byte[4096];
   int c = 0;
   while (( c = in.read(buffer, 0, 4096)) > 0) {
      out.write(buffer, 0, c);
   }
} finally {
   if (in != null) {
      in.close();
   }
   if (out != null) {
      out.close();
   }
}