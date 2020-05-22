MethodInvocationTree node = ...;
  TypeMirror receiver;
  if (methodSel.getKind() == Tree.Kind.MEMBER_SELECT) {
    ExpressionTree receiver = ((MemberSelectTree)methodSel).getExpression();
    receiverType = ((JCTree)receiver).type;
  } else if (methodSel.getKind() == Tree.Kind.IDENTIFIER) {
    // need to resolve implicit this, which is described in
    //  JLS3 15.12.1 and 15.9.2

    // A bit too much work that I don't want to work on now
    // Look at source code of
    //   Attr.visitApply(JCMethodInvocation)
    //   resolveImplicitThis(DiagnosticPosition, Env, Type)
  } else
    throw new AssertionError("Unexpected type: " + methodSel.getKind());