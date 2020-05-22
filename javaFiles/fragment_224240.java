/**
 * Returns the number of variable declarations inside the given method, by parsing the method's AST
 * @param method The method text
 */
private int countVariableDeclarations(String method) {
    JavaLexer lex = new JavaLexer(new ANTLRInputStream(method));
    JavaParser parse = new JavaParser(new CommonTokenStream(lex));
    ParseTree tree = parse.methodDeclaration();

    ParseTreeWalker walker = new ParseTreeWalker();
    final AtomicInteger count = new AtomicInteger();
    walker.walk(new JavaBaseListener() {
        @Override public void enterLocalVariableDeclaration(JavaParser.LocalVariableDeclarationContext ctx) {
            count.incrementAndGet();
        }
    }, tree);

    return count.get();
}