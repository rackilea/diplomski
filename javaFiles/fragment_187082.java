private static String longToString(String string) {
    StringBuffer sb = new StringBuffer();
    for (int i = 0; i < string.length(); i = i + 3) {
        String substring = string.substring(i, i + 3);
        char ch = (char) Integer.parseInt(substring);
        sb.append(ch);
    }
    return sb.toString();
}

private static String stringToLong(String string) {
    StringBuffer sb = new StringBuffer();
    for (int i = 0; i < string.length(); ++i) {
        int ch = (int) string.charAt(i);
        if (ch < 100) {
            if(ch<10)
            {
            sb.append('0');
            }
            sb.append('0').append(ch);
        } else {
            sb.append(ch);
        }
    }
    return sb.toString();
}