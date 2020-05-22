ICompilationUnit icu = ...

ASTParser parser = ASTParser.newParser(AST.JLS3);
parser.setResolveBindings(true);
parser.setSource(icu);
CompilationUnit cu = (CompilationUnit) parser.createAST(null);
cu.accept(new ASTVisitor() {
    @Override
    public boolean visit(VariableDeclarationStatement node) {
        System.out.println("node=" + node);
        System.out.println("node.getType()=" + node.getType());
        return true;
    }
});