Block block = ast.newBlock();
TextElement siso = ast.newTextElement();
siso.setText("System.out.println(\"hello\");");

ListRewrite listRewrite = rewriter.getListRewrite(block,  CompilationUnit.IF_STATEMENT);    
listRewrite.insertFirst(siso, null);

TextEdit edits = rewriter.rewriteAST(document, null);