public static String trimSubstring(StringBuilder sb) {
    int first, last;

    for (first=0; first<sb.length(); first++)
        if (!Character.isWhitespace(sb.charAt(first)))
            break;

    for (last=sb.length(); last>first; last--)
        if (!Character.isWhitespace(sb.charAt(last-1)))
            break;

    return sb.substring(first, last);
}