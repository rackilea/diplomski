static Type getArgument(TypeVariable<?>   var,
                        ParameterizedType actual) {
    GenericDeclaration decl = var.getGenericDeclaration();
    if (decl != actual.getRawType())
        throw new IllegalArgumentException();
    TypeVariable<?>[] vars = decl.getTypeParameters();
    for (int i = 0; i < vars.length; ++i) {
        if (var == vars[i]) {
            return actual.getActualTypeArguments()[i];
        }
    }
    return null;
}