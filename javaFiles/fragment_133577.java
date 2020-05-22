public static void parse(String fileContent) {
    //advise the parser to parse the code following to the Java Language Specification, Third Edition.
    ASTParser parser = ASTParser.newParser(AST.JLS3); 
    Map options = JavaCore.getOptions();
    JavaCore.setComplianceOptions(JavaCore.VERSION_1_5, options);
    parser.setCompilerOptions(options);

    // tell the parser, that it has to expect an ICompilationUnit (a pointer to a Java file) as input.
    parser.setKind(ASTParser.K_COMPILATION_UNIT);       
    parser.setSource(fileContent.toCharArray());
    parser.setResolveBindings(true);
    final CompilationUnit cu = (CompilationUnit) parser.createAST(null);

    cu.accept(new ASTVisitor() {
        public boolean visit(AnnotationTypeDeclaration node) {
            System.out.println("Annotaion: " + node.getName());
            return true;
        }

        public boolean visit(TypeDeclaration node) {
            System.out.println("Type: " + node.getName());
            return true;
        }
    });
}