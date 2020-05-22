public static <T extends ICommand> List<Class<? extends ICommandHandler<T>>> getCommandHandlers(
        Class<T> commandClass, String packageName
) {
    return new Reflections(packageName).getSubTypesOf(ICommandHandler.class).stream()
            .filter(subtype -> !subtype.isInterface())
            .filter(subtype -> Objects.equals(getParameter(subtype, ICommandHandler.class, 0), commandClass))
            .map(subtype -> (Class<? extends ICommandHandler<T>>) subtype)
            .collect(Collectors.toList());
}


@Nullable
public static <T> Type getParameter(
        Class<T> clazz,
        Class<? super T> parametrizedParent,
        int index
) {
    Type result = null;
    for (ParameterizedType parent : getParameterizedParents(clazz, parametrizedParent)) {
        result = parent.getActualTypeArguments()[index];
        if (!(result instanceof TypeVariable)) return result;
        index = getTypeVariableIndex((TypeVariable<?>) result);
    }
    return result;
}

private static <T> List<ParameterizedType> getParameterizedParents(Class<? extends T> clazz, Class<T> parent) {
    List<ParameterizedType> genericParents = new ArrayList<>();
    Class<? extends T> current = clazz;
    while (true) {
        Type supertype = getSuperType(current, parent);
        if (supertype instanceof ParameterizedType)
            genericParents.add((ParameterizedType) supertype);
        else genericParents.clear();
        Type rawSupertype = toRawType(supertype);
        if (rawSupertype == parent) {
            Collections.reverse(genericParents);
            return genericParents;
        }
        current = (Class<? extends T>) rawSupertype;
    }
}

private static <T> Type getSuperType(Class<? extends T> child, Class<T> parent) {
    if (child == parent) return child;
    Type superclass = child.getGenericSuperclass();
    if (isSubTypeOfClass(superclass, parent)) return superclass;
    for (Type type : child.getGenericInterfaces())
        if (isSubTypeOfClass(type, parent)) return type;
    throw new IllegalArgumentException(child.getName() + " is not assignable from " + parent.getName());
}

private static int getTypeVariableIndex(final TypeVariable<?> typeVariable) {
    return Arrays.asList(typeVariable.getGenericDeclaration().getTypeParameters()).indexOf(typeVariable);
}

private static boolean isSubTypeOfClass(Type type, Class<?> clazz) {
    Type rawType = toRawType(type);
    return rawType instanceof Class && clazz.isAssignableFrom((Class<?>) rawType);
}

private static Type toRawType(Type type) {
    return type instanceof ParameterizedType ? ((ParameterizedType) type).getRawType() : type;
}