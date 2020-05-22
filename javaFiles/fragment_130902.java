public boolean visit(VariableDeclarationFragment f) {
  if (f.getParent() instanceof FieldDeclaration) {
    FieldDeclaration d = (FieldDeclaration) f.getParent();
    if (d.getType().isParameterizedType()) {
      ParameterizedType parType = (ParameterizedType) d.getType();
      System.out.println("Par type : " + parType.typeArguments().get(0).toString());
    }
  }
}