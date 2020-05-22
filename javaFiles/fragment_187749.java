for (ICompilationUnit unit : mypackage.getCompilationUnits()) {
    IType primary = unit.findPrimaryType();
    IMethod[] methods = primary.getMethods();
    int i = 1;
    for (IMethod method : methods) {
        if (method.isConstructor()) {
            continue;
        }
    makeChangetoMethods(status, method,"changedMethodVersion_" + i);
    ++i;
    }
}