// get raw type argument of first parameter
public static Class<?> getRawTypeArgument(Method method) {
    Parameter parameter = method.getParameters()[0];
    Type type = parameter.getParameterizedType();
    /// assume it's parameterized
    ParameterizedType parameterizedType = (ParameterizedType) type;
    // assume there's one type argument
    Type typeArgument = parameterizedType.getActualTypeArguments()[0];
    if (typeArgument instanceof TypeVariable<?>) {
        TypeVariable<?> typeVariableArgument = (TypeVariable<?>) typeArgument;
        return recursivelyExtractBound(typeVariableArgument);
    } else if (typeArgument instanceof Class<?>) {
        return (Class<?>) typeArgument;
    } else if (typeArgument instanceof ParameterizedType) {
        ParameterizedType parameterizedTypeArgument = (ParameterizedType) typeArgument;
        return (Class<?>) parameterizedTypeArgument.getRawType();
    } 
    throw new AssertionError("Consider wildcard and generic type");
}

private static Class<?> recursivelyExtractBound(TypeVariable<?> typeVariable) {
    // assume first
    Type bound = typeVariable.getBounds()[0];
    if (bound instanceof Class<?>) {
        return (Class<?>) bound;
    } else if (bound instanceof TypeVariable<?>) {
        TypeVariable<?> nested = (TypeVariable<?>) bound;
        return recursivelyExtractBound(nested);
    } else if (bound instanceof ParameterizedType) {
        ParameterizedType parameterizedTypeArgument = (ParameterizedType) bound;
        return (Class<?>) parameterizedTypeArgument.getRawType();
    }
    throw new AssertionError("Are there others?");
}