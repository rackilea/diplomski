// Encrypt Password to UTF-8 format

private String encrypt(String pwd) {
    String encryptedPwd = null;
    try {
        byte[] byteArray = pwd.getBytes("UTF-8");
        encryptedPwd = Base64.encodeToString(byteArray, Base64.DEFAULT).trim();
    } catch (UnsupportedEncodingException e) {
        e.printStackTrace();
    }
    return encryptedPwd;
}