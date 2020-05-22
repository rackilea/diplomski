if (!("private".equals(variableScope)
    || inInterfaceOrAnnotationBlock // implicitly static and final
    || (mods.contains("static") && mods.contains("final"))
    || ("package".equals(variableScope) && isPackageAllowed())
    || ("protected".equals(variableScope) && isProtectedAllowed())
    || ("public".equals(variableScope)
        && getPublicMemberRegexp().matcher(varName).find())))
{
    log(varNameAST.getLineNo(), varNameAST.getColumnNo(),
        "variable.notPrivate", varName);
}