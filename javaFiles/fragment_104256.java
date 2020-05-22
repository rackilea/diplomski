private static final String AMP = "&amp;";
private static final String LT = "&lt;";
private static final String GT = "&gt;";
private static final String QUOTE = "&quot;";
private static final String APOS = "&apos;";

public static String encodeEntities(String dirtyString) {

    StringBuffer buff = new StringBuffer();
    char[] chars = dirtyString.toCharArray();

    for (int i = 0; i < chars.length; i++) {
        if (chars[i] > 0x7f) {
            buff.append("&#" + (int) chars[i] + ";");
            continue;
        }

        switch (chars[i]) {
        case '&':
            buff.append(AMP);
            break;
        case '<':
            buff.append(LT);
            break;
        case '\'':
            buff.append(APOS);
            break;
        case '"':
            buff.append(QUOTE);
            break;
        case '>':
            buff.append(GT);
            break;
        default:
            buff.append(chars[i]);
            break;
        }
    }

    return buff.toString();
}