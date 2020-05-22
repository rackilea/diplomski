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
    int i = 0, j;
    char ch1, ch2;
    while (i < unicodeStr.length()) {
        if (isUnicodeEncoded(unicodeStr, i)) {
            ch1 = (char) Integer.parseInt(unicodeStr.substring(i+2, i+6), 16);
            j = 6;
        }
        else {
            ch1 = unicodeStr.charAt(i);
            j = 1;
        }
        i += j;
        if (Character.isHighSurrogate(ch1) && (i < unicodeStr.length())) {
            if (isUnicodeEncoded(unicodeStr, i)) {
                ch2 = (char) Integer.parseInt(unicodeStr.substring(i+2, i+6), 16);
                j = 6;
            }
            else {
                ch2 = unicodeStr.charAt(i);
                j = 1;
            }
            if (Character.isLowSurrogate(ch2)) {
                list.add(String.valueOf(new char[]{ch1, ch2}));
                i += j;
                continue;
            }
        }
        list.add(String.valueOf(ch1));
    }
    return list.toArray(new String[list.size()]);
}