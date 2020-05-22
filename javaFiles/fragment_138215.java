public class Main {

    private enum Type {
      LB, RB, NUMBER, END
    }

    private static class Token {
      Type type;
      String value;

      public Token(Type type, String value) {
          super();
          this.type = type;
          this.value = value;
      }

      @Override
      public String toString() {
          return "Token [type=" + type + ", value=" + value + "]";
      }

    }

    private static class Lexer {

      private int current;
      private String input;

      public Lexer(String input) {
          this.input = input;
      }

      private char getChar() {
          return input.charAt(current++);
      }

      private void unputChar() {
          current--;
      }

      private boolean hasNextChar() {
          return current < input.length();
      }

      Token next() {

          if (!hasNextChar()) {
            return new Token(Type.END, "");
          }

          char c = getChar();

          while (Character.isWhitespace(c)) {
            c = getChar();
          }

          if (c == '[') {
            return new Token(Type.LB, "[");
          }

          if (c == ']') {
            return new Token(Type.RB, "]");
          }

          int s = 1;
          if (c == '-') {
            s = -1;
          } else {
            unputChar();
          }

          StringBuilder buffer = new StringBuilder();
          while (hasNextChar()) {

            c = getChar();

            if (Character.isDigit(c)) {
              buffer.append(c);
            } else {
              unputChar();
              break;
            }

          }

          return new Token(Type.NUMBER, s > 0 ? buffer.toString() : "-" + buffer.toString());

      }
    }

    private static boolean match(Type type) {
      return type == currentToken.type;
    }

    private static void consume(Type type) {
      if (!match(type)) {
          throw new RuntimeException(String.format("Should be %s is %s", type.name(), currentToken.type.name()));
      }
      currentToken = lexer.next();
    }

    private static void array() {

      consume(Type.LB);

      while (true) {

          if (match(Type.NUMBER)) {
            consume(Type.NUMBER);
          } else if (match(Type.LB)) {
            array();
          } else {
            break;
          }

      }

      consume(Type.RB);
    }

    private static Lexer lexer;
    private static Token currentToken;

    private static void parse(String line) {

      lexer = new Lexer(line);
      currentToken = lexer.next();

      try {
          array();
          consume(Type.END);
          System.out.println(String.format("%s is a proper array", line));
      } catch (Exception e) {
          System.out.println(String.format("%s is not a proper array because %s", line, e.getMessage()));
      }

    }

    public static void main(String[] args) {

      parse("[1 2 [-34 7] 34]");
      parse("[1 2 -34 7] 34]");
      parse("[1 2 [-34] [7] 34]");
      parse("[1 2 [-34 [7] 34]");
      parse("[1 2 [-34 [7] 34]]");

    }

}