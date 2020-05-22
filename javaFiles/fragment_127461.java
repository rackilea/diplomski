public static String MySQLPassword(String plainText)
                  throws UnsupportedEncodingException
{
    byte[] utf8 = plainText.getBytes("UTF-8");
    byte[] test = DigestUtils.sha(DigestUtils.sha(utf8));
    return "*" + convertToHex(test).toUpperCase();
}