ASTParser parser = ASTParser.newParser(AST.JLS3);
parser.setSource(compilationUnit);
parser.setSourceRange(method.getSourceRange().getOffset(), method.getSourceRange().getLength());
parser.setResolveBindings(true);
CompilationUnit cu = (CompilationUnit)parser.createAST(null);
cu.accept(new ASTMethodVisitor());