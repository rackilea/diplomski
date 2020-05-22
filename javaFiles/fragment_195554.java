import org.antlr.runtime.*;

public class CSVLexerTest {

  public static void main(String[] args) throws Exception {

    // the input source  
    String source =
        "val1, value2, value3, value3.2" + "\n" + 
        "\"line\nbreak\",ABAbb,end";

    // create an instance of the lexer  
    CSVLexer lexer = new CSVLexer(new ANTLRStringStream(source));

    // wrap a token-stream around the lexer and fill the tokens-list 
    CommonTokenStream tokens = new CommonTokenStream(lexer);
    tokens.fill();

    // traverse the tokens and print them to see if the correct tokens are created
    // tokens.toString();
    int n = 1;
    for (Object o : tokens.getTokens()) {
      CommonToken token = (CommonToken) o;
      System.out.println("token(" + n + ") = " + token.getText().replace("\n",    "\\n"));
      n++;
    }
  }
}