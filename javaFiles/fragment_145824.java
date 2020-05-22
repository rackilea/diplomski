public class TestDebugMeGrammar {

    public static void main(String[] args) throws Exception {

        CharStream input = new ANTLRStringStream("var x = 3; print(x);");

        DebugMeLexer lexer = new DebugMeLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        DebugMeParser parser = new DebugMeParser(tokens, newEventListener());

        parser.compilationUnit();
    }
    //...
}