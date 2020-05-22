private static final String timestampAlphabet =
    "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_";

public static String encodeTimestamp(Date date) {
    long t = date.getTime();
    StringBuilder timestamp = new StringBuilder();
    do {
        timestamp.append(timestampAlphabet.charAt((int)(t % 64)));
    } while ((t /= 64) != 0);
    return timestamp.reverse().toString();
}

public static Date decodeTimestamp(String timestamp) {
    long t = 0;
    for (char c : timestamp.toCharArray()) {
        t = t * 64 + timestampAlphabet.indexOf(c);
    }
    return new Date(t);
}