import org.antlr.runtime.*;

public class Main {
    public static void main(String[] args) throws Exception {
        ANTLRStringStream in = new ANTLRStringStream("create a red box");
        ShrdluLexer lexer = new ShrdluLexer(in);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        java.awt.Graphics g = null;
        ShrdluParser parser = new ShrdluParser(tokens, g);
        parser.command();
    }
}