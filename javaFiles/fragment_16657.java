/*
 * imagePath has changed name to path, as the file doesn't have to be an image.
 */
File file = new File(path);
long length = file.length();
BufferedInputStream bis = null;
try {
    bis = new BufferedInputStream(new FileInputStream(file));
    if(length > Integer.MAX_VALUE) {
        throw new IOException("File must be smaller than 2 GB.");
    }
    byte[] data = new byte[(int)length];
    //Read bytes from file
    bis.read(data);
} catch (IOException e) {
    e.printStackTrace();
} finally {
    if(bis != null)
        try { bis.close(); }
        catch(IOException e) {}
}
//Gzip and encode to base64
String base64Str = Base64.encodeBytes(data, Base64.GZIP);