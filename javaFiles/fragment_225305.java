import org.antlr.runtime.*;

public class Main {
    public static void main(String[] args) throws Exception {
        ANTLRStringStream in = new ANTLRStringStream("(8-3)>6");
        BooleanCalculatorLexer lexer = new BooleanCalculatorLexer(in);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        BooleanCalculatorParser parser = new BooleanCalculatorParser(tokens);
        parser.prog();
    }
}