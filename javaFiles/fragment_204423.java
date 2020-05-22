ClassTree classTree = (ClassTree) tree;
Symbol.TypeSymbol classSymbol = classTree.symbol();
Type superClass = classSymbol.superClass();
SymbolMetadata superClassMetadata = superClass.symbol().metadata();
if (superClassMetadata.isAnnotatedWith("org.acme.MyAnnotation")) {
  //...
}