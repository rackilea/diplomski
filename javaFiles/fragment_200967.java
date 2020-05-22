public static void main(String[] args) throws Exception {

    String expression = "n = 1\n" +
            "while (n < 10) {\n" +
            "  n\n" +
            "  n = n + 1\n" +
            "}\n";
    ExprLexer lexer = new ExprLexer(new ANTLRInputStream(expression));
    ExprParser parser = new ExprParser(new CommonTokenStream(lexer));
    new EvalVisitor().visit(parser.prog());
}