static class Parser {
    private int pos = 0;
    private String s;
    public Parser(String s) {
        this.s = s;
    }
    private void skipSpace() {
        while (pos != s.length() && Character.isWhitespace(s.charAt(pos))) {
            pos++;
        }
    }
    public Node parse() {
        skipSpace();
        Node res = new Node();
        res.variableName = s.charAt(pos++);
        skipSpace();
        if (pos == s.length()) return res;
        if (s.charAt(pos) == '?') {
            pos++;
            res.left = parse();
            skipSpace();
            if (pos == s.length() || s.charAt(pos) != ':') {
                System.err.println("Syntax error");
                return null;
            }
            pos++;
            res.right = parse();
        }
        return res;
    }
}

public static Node parse(String s) {
    Parser p = new Parser(s);
    return p.parse();
}