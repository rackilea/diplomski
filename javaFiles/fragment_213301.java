public class Main {

    public static void main(String[] args) {
        String test = "a > b >= c > x";
        Main m = new Main(test);
        System.out.println(m.getTokenNumber());

        test = "aasdfasdf asdfdasf";
        m = new Main(test);
        System.out.println(m.getTokenNumber());
    }

    private String input;
    private int pos;

    public Main(String input) {
        this.input = input;
        pos = 0;
    }

    public TokenNumber getTokenNumber() {
        TokenNumber tokenNumber = new TokenNumber();
        Token t = nextToken();
        while (t != Token.NONE) {
            tokenNumber.addToken(t);
            t = nextToken();
        }
        return tokenNumber;
    }

    private Token nextToken() {
        while (pos < input.length() && input.charAt(pos) != '>') pos++;
        if (pos == input.length()) return Token.NONE;
        pos++;
        if (pos == input.length() || input.charAt(pos) != '=') return Token.GREATER;
        return Token.GREATER_EQUAL;
    }

    enum Token {
        GREATER, GREATER_EQUAL, NONE;
    }

    static class TokenNumber {
        public int greater;
        public int greater_than;

        public void addToken(Token t) {
            if (t == Token.GREATER) greater++;
            else greater_than++;
            assert t != Token.NONE;
        }

        public String toString() {
            return String.format("Greater: %d%nGreater Than: %d", greater, greater_than);
        }
    }

}