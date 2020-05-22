byte[] buff = null;
try {
   buff = string.getBytes("UTF-8");
} catch (UnsupportedEncodingException e) {
   e.printStackTrace();
}