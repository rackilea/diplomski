class MyVisitor extends ASTVisitor
{
  private List<Type> superTypes = new ArrayList<>();

  @Override
  public boolean visit(TypeDeclaration typeDecNode) {
       if(!typeDecNode.isInterface()) {
            superTypes.add(typeDecNode.getSuperclassType());
            return true;
       }
  }

  List<Type> getSuperTypes() {
     return superTypes;
  }
}