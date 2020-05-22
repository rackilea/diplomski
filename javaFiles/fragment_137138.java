unit.accept(new ASTVisitor() {
    @Override
    public boolean visit(TypeDeclaration node) {
        IType type = (IType) node.resolveBinding().getTypeDeclaration().getJavaElement();
        if (ejbType.equals(type)) {
            modifyTypeDeclaration(node);
        }
        return false;
    }
});