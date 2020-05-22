public static String compressString(String str) throws IOException{
if (str == null || str.length() == 0) {
    return str;
}
ByteArrayOutputStream out = new ByteArrayOutputStream(str.length());
GZIPOutputStream gzip = new GZIPOutputStream(out);
gzip.write(str.getBytes());
gzip.close();

byte[] compressedBytes = out.toByteArray(); 

Gdx.files.local("gziptest.gzip").writeBytes(compressedBytes, false);
out.close();

return out.toString(); // I would return compressedBytes instead String
}