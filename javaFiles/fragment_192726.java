import org.antlr.runtime.*;

public class Main {
  public static void main(String[] args) throws Exception {
    String source = "(1 & 0) | 1";
    TestLexer lexer = new TestLexer(new ANTLRStringStream(source));
    TestParser parser = new TestParser(new CommonTokenStream(lexer));
    System.out.println(source + " = " + parser.code());
  }
}