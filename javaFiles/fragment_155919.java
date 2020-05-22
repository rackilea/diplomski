private boolean isIterbale(ExpressionTree expression) {
    TypeMirror tm = workingCopy.getTrees().getTypeMirror(TreePath.getPath(workingCopy.getCompilationUnit(), expression));
    if (!Utilities.isValidType(tm)) {
        return false;
    }
    if (tm.getKind() == TypeKind.ARRAY) {
        return false;
    } else {
        tm = workingCopy.getTypes().erasure(tm);
        TypeElement typeEl = workingCopy.getElements().getTypeElement("java.util.Collection");
        if (typeEl != null) {
            TypeMirror collection = typeEl.asType();
            collection = workingCopy.getTypes().erasure(collection);
            if (this.workingCopy.getTypes().isSubtype(tm, collection)) {
                return true;
            }
        }
    }

    return false;
}