private boolean isUnicodeEncoded(string s, int index)
{
    return (
        (s.charAt(index) == '\\') &&
        ((index+5) < s.length()) &&
        (s.charAt(index+1) == 'u')
    );
}

private String[] getCharArray(String unicodeStr) {
    ArrayList<String> list = new ArrayList<>();
    int i = 0, j, start;
    char ch;
    while (i < unicodeStr.length()) {
        start = i;
        if (isUnicodeEncoded(unicodeStr, i)) {
            ch = (char) Integer.parseInt(unicodeStr.substring(i+2, i+6), 16);
            j = 6;
        }
        else {
            ch = unicodeStr.charAt(i);
            j = 1;
        }
        i += j;
        if (Character.isHighSurrogate(ch) && (i < unicodeStr.length())) {
            if (isUnicodeEncoded(unicodeStr, i)) {
                ch = (char) Integer.parseInt(unicodeStr.substring(i+2, i+6), 16);
                j = 6;
            }
            else {
                ch = unicodeStr.charAt(i);
                j = 1;
            }
            if (Character.isLowSurrogate(ch)) {
                i += j;
            }
        }
        list.add(unicodeStr.substring(start, i));
    }
    return list.toArray(new String[list.size()]);
}