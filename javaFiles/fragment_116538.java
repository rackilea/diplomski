public static boolean isUtf8Encoded(String url) {
    return isAlphaNumeric(url);
}

public static boolean isUrlUtf8Encoded(String url)
        throws UnsupportedEncodingException {
    return isAlphaNumeric(URLDecoder.decode(url, "UTF-8"));
}

public static boolean isUrlIsoEncoded(String url)
        throws UnsupportedEncodingException {
    return isAlphaNumeric(URLDecoder.decode(url, "ISO-8859-1"));
}

private static boolean isAlphaNumeric(String decode) {
    for (char c : decode.toCharArray()) {
        if (!Character.isLetterOrDigit(c)) {
            return false;
        }
    }
    return true;
}