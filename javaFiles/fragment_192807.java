final List<Type> superTypes = new ArrayList<>();

cu.accept(new ASTVisitor() {
     public boolean visit(TypeDeclaration typeDecNode) {
        if(!typeDecNode.isInterface()) {
            superTypes.add(typeDecNode.getSuperclassType());

            return true;
        }