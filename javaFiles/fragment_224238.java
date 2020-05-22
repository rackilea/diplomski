public static void main(String... args) throws IOException {
    JavaLexer lexer = new JavaLexer(new ANTLRFileStream(sourceFile, "UTF-8"));
    JavaParser parser = new JavaParser(new CommonTokenStream(lexer));
    ParseTree tree = parser.compilationUnit();

    ParseTreeWalker walker = new ParseTreeWalker();
    MyListener listener = new MyListener();
    walker.walk(listener, tree);
}