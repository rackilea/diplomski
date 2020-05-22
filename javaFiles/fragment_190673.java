public static String htmlEscapeUnmappableCharaters(String source, String charset) {
    CharsetEncoder cse = Charset.forName(charset).newEncoder();

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < source.length(); i++) {

        if (cse.canEncode(source.charAt(i))) {
            sb.append(source.charAt(i));
        } else {
            sb.append('&');
            sb.append('#');
            sb.append(source.codePointAt(i));
            sb.append(';');
        }
    }

    return sb.toString();
}