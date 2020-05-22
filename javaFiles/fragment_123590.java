import org.apache.commons.codec.binary.Base64;

public static String base64UrlDecode(String input) {
    String result = null;
    Base64 decoder = new Base64(true);
    byte[] decodedBytes = decoder.decode(input);
    result = new String(decodedBytes);
    return result;
}