/**
 * Takes a URI that was decoded as ISO-8859-1 and applies percent-encoding
 * to non-ASCII characters. Workaround for broken origin servers that send
 * UTF-8 in the Location: header.
 */
static String encodeUriFromHeader(String uri) {
    StringBuilder sb = new StringBuilder();

    for(char ch : badLocation.toCharArray()) {
        if(ch < (char)128) {
            sb.append(ch);
        } else {
            // this is ONLY valid if the uri was decoded using ISO-8859-1
            sb.append(String.format("%%%02X", (int)ch));
        }
    }

    return sb.toString();
}