new ASTVisitor() {
    @Override
    public boolean visit(ConditionalExpression node) {
        ...
        return false;
    }
}