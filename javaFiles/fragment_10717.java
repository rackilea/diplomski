public static String compress_string(String inp) {
    String compressed = "";
    Pattern pattern = Pattern.compile("([\\w])\\1*");
    Matcher matcher = pattern.matcher(inp);
    while (matcher.find()) {
        String group = matcher.group();
        if (group.length() > 1) compressed += group.length() + "";
        compressed += group.charAt(0);
    }
    return compressed;
}

public static String decompress_string(String inp) {
    StringBuilder s = new StringBuilder();
    for (int i = 0; i < inp.length(); i++) {
        char ch = inp.charAt(i);
        if (ch == '1') {
            s.append('1');
        } else {
            int count = ch - '0';
            String repeat = "" + inp.charAt(++i);
            s.append(String.join("", Collections.nCopies(count, repeat)));
        }
    }
    return s.toString();
}

public void test(String[] args) throws Exception {
    String test = "111111";
    String compressed = compress_string(test);
    String decompressed = decompress_string(compressed);
    System.out.println("test = '" + test + "' compressed = '" + compressed + "' decompressed = '" + decompressed + "'");
}