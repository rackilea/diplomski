private void addAnnotations(final ICompilationUnit cu) throws MalformedTreeException, BadLocationException, CoreException {

     // parse compilation unit
    final ASTParser parser = ASTParser.newParser(AST.JLS3);
    parser.setSource(cu);
    final CompilationUnit astRoot = (CompilationUnit) parser.createAST(null);


    // create a ASTRewrite
    final AST ast = astRoot.getAST();
    final ASTRewrite rewriter = ASTRewrite.create(ast);



    final ListRewrite listRewrite = rewriter.getListRewrite(astRoot, CompilationUnit.TYPES_PROPERTY);
    final NormalAnnotation eventHandlerAnnotation = astRoot.getAST().newNormalAnnotation();
    eventHandlerAnnotation.setTypeName(astRoot.getAST().newName("CustomAnnotation"));
    eventHandlerAnnotation.values().add(createAnnotationMember(ast, "arg1", "Blup"));
    eventHandlerAnnotation.values().add(createQualifiedAnnotationMember(ast, "arg2", "IsWorkbenchTest", "Blab"));


    final SingleMemberAnnotation runWithFop = astRoot.getAST().newSingleMemberAnnotation();
    runWithFop.setTypeName(astRoot.getAST().newName("SimpleAnnotation"));
    final TypeLiteral newTypeLiteral = astRoot.getAST().newTypeLiteral();
    newTypeLiteral.setType(astRoot.getAST().newSimpleType(astRoot.getAST().newSimpleName("Blop")));
    runWithFop.setValue(newTypeLiteral);
    listRewrite.insertAt(runWithFop, 0, null);
    listRewrite.insertAt(eventHandlerAnnotation, 0, null);
    final TextEdit edits = rewriter.rewriteAST();

    // apply the text edits to the compilation unit
    final Document document = new Document(cu.getSource());
    edits.apply(document);

    // this is the code for adding statements
    cu.getBuffer().setContents(formatFileContent(document.get()));
    cu.save(null, true);
}
protected MemberValuePair createQualifiedAnnotationMember(final AST ast, final String name, final String value, final String value2) {
    final MemberValuePair mV = ast.newMemberValuePair();
    mV.setName(ast.newSimpleName(name));
    final TypeLiteral typeLiteral = ast.newTypeLiteral();
    final QualifiedType newQualifiedName = ast.newQualifiedType(ast.newSimpleType(ast.newSimpleName(value)), ast.newSimpleName(value2));
    typeLiteral.setType(newQualifiedName);
    mV.setValue(typeLiteral);
    return mV;
}

protected MemberValuePair createAnnotationMember(final AST ast, final String name, final String value) {

    final MemberValuePair mV = ast.newMemberValuePair();
    mV.setName(ast.newSimpleName(name));
    final TypeLiteral typeLiteral = ast.newTypeLiteral();
    typeLiteral.setType(ast.newSimpleType(ast.newSimpleName(value)));
    mV.setValue(typeLiteral);
    return mV;
}