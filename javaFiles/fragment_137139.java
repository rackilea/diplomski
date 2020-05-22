ICompilationUnit cu = ejbType.getCompilationUnit();
cu.becomeWorkingCopy(...);
CompilationUnit unit = parseAst(ejbType.getCompilationUnit())
final ASTRewrite rewrite = ASTRewrite.create(unit.getAST());
collectChangesToUnit(unit, rewrite);
cu.applyTextEdit(rewrite.rewriteAST(), ...);
cu.commitWorkingCopy(false, ...);