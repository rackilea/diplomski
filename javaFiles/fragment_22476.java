//character set you want to use
public static char[] CHARSET_AZ_09 = "abcdefghijklmnopqrstuvwxyz0".toCharArray();


public static String randomString(char[] characterSet, int length) {
    int charsetLength = characterSet.length;
    char[] result = new char[length];
    for (int i = 0; i < result.length; i++) {
        int randomCharIndex = (int)(Math.random()*charsetLength);
        result[i] = characterSet[randomCharIndex];
    }
    return new String(result);
}