public static void main(String[] ar) {
    String s = "aaa 'bb;bb;bb' aaa;  aaa 'bb;bb\\';bb' aaa";
    System.out.println(splitStatments(s, ';'));
}

private static List<String> splitStatments(String s, char statementDelimiter) {
    List<String> statements = new ArrayList<String>();
    StringBuffer sb = new StringBuffer();
    boolean outsideString = true;
    char lastChar = 0;
    for (char c : s.toCharArray()) {
        // in the case of the escaped \', we DON'T want to flip the boolean
        if (c == '\'' && lastChar != '\\') {
            outsideString = !outsideString;
        }
        if (c == statementDelimiter && outsideString) {
            statements.add(sb.toString());
            sb = new StringBuffer();
        } else {
            sb.append(c);
        }
        lastChar = c;
    }
    if (sb.length() > 0) {
        statements.add(sb.toString());
    }
    return statements;
}