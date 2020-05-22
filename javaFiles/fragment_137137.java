public static CompilationUnit parseAst(ICompilationUnit unit, SubMonitor progress) {
    ASTParser parser = ASTParser.newParser(AST.JLS8);
    parser.setSource(unit);
    parser.setResolveBindings(true);
    return (CompilationUnit)parser.createAST(progress);
}