import org.antlr.runtime.*;

public class ANTLRDemo {
    public static void main(String[] args) throws Exception {
        ANTLRStringStream in = new ANTLRStringStream("12*(5-6)");
        ExpLexer lexer = new ExpLexer(in);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ExpParser parser = new ExpParser(tokens);
        System.out.println(parser.eval()); // print the value
    }
}