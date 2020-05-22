public static String SHA1(String text) throws NoSuchAlgorithmException, UnsupportedEncodingException {
    String result;
    MessageDigest md = MessageDigest.getInstance("SHA-1");
    md.update(text.getBytes("iso-8859-1"), 0, text.length());
    byte[] sha1hash = md.digest();
    result = Base64.encodeToString(sha1hash, Base64.DEFAULT);
    result = result.substring(0, result.length()-1);
    return result;
}