IFile myJavaFile = <get the file>
ICompilationUnit unit = JavaCore.createFromFile(myJavaFile);
IType[] types = unit.getAllTypes();
for (IType type : types) {
  ITypeHierarchy th= type.newTypeHierarchy(null);
  // do something with the hierarchy
}