import java.io.File;
import org.antlr.runtime.*;

public class Main {
  public static void main(String[] args) throws Exception {
    String source = "42 500000000 666";
    TLexer lexer = new TLexer(new ANTLRStringStream(source));
    TParser parser = new TParser(new CommonTokenStream(lexer), "log.txt");
    parser.parse();
  }
}