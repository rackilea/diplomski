BufferedImage img = null;
InputStream is = null;
try {
    // url begin an instance of java.net.URL
    is = url.openStream();
    img = ICODecoder.read(is);
} finally {
   try {
       is.close();
   } catch (Exception exp) {
   }
}
return img;