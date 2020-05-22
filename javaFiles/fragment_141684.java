String original = JsonObj.getString("title");
try {
   byte[] utf8Bytes = original.getBytes("UTF-8");
   String roundTrip = new String(utf8Bytes, "UTF-8");
} 
catch (UnsupportedEncodingException e) {
    e.printStackTrace();
}