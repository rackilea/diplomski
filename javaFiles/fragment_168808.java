public static Set<Method> getAnnotatedMethods(
              Class<?> actualClass, Class<? extends Annotation> a) {
    Set<Method> raw = getRawAnnotatedMethods(actualClass, a);
    if(raw.isEmpty()) return raw;
    Set<Method> resolved = new HashSet<>();
    for(Method m: raw) {
        if(m.getDeclaringClass()==actualClass) resolved.add(m);
        else {
            Method x = getMoreSpecific(actualClass, m);
            resolved.add(!x.isBridge()? x: resolveGeneric(x, m));
        }
    }
    return resolved;
}
private static Method resolveGeneric(Method x, Method m) {
    final Class<?> decl = m.getDeclaringClass();
    Map<Type,Type> translate = new HashMap<>();
    up: for(Class<?> c=x.getDeclaringClass(); c!=decl; ) {
        if(decl.isInterface()) {
            for(Type t: c.getGenericInterfaces()) {
                Class<?> e = erased(t);
                if(updateMap(decl, e, t, translate)) continue;
                c = e;
                continue up;
            }
        }
        Type t = c.getGenericSuperclass();
        c = erased(t);
        updateMap(decl, c, t, translate);
    }
    Class<?>[] raw = m.getParameterTypes();
    Type[] generic = m.getGenericParameterTypes();
    for(int ix = 0; ix<raw.length; ix++)
        raw[ix] = erased(translate.getOrDefault(generic[ix], raw[ix]));
    return getMoreSpecific(x.getDeclaringClass(), x, raw);
}
private static Method getMoreSpecific(Class<?> actual, Method inherited) {
    return getMoreSpecific(actual, inherited, inherited.getParameterTypes());
}
private static Method getMoreSpecific(
               Class<?> actual, Method inherited, Class<?>[] pTypes) {
    try {
        final String name = inherited.getName();
        if(inherited.getDeclaringClass().isInterface()
        || Modifier.isPublic(inherited.getModifiers())) {
            return actual.getMethod(name, pTypes);
        }
        for(;;) try {
            return actual.getDeclaredMethod(name, pTypes);
        }
        catch(NoSuchMethodException ex) {
            actual = actual.getSuperclass();
            if(actual == null) throw ex;
        }
    }
    catch(NoSuchMethodException ex) {
        throw new IllegalStateException(ex);
    }
}

private static boolean updateMap(Class<?> decl, Class<?> e, Type t, Map<Type, Type> m) {
    if (!decl.isAssignableFrom(e)) {
        return true;
    }
    if(t!=e) {
        TypeVariable<?>[] tp = e.getTypeParameters();
        if(tp.length>0) {
            Type[] arg = ((ParameterizedType)t).getActualTypeArguments();
            for(int ix=0; ix<arg.length; ix++)
                m.put(tp[ix], erased(m.getOrDefault(arg[ix], arg[ix])));
        }
    }
    return false;
}
private static Class<?> erased(Type t) {
    if(t instanceof Class<?>) return (Class<?>)t;
    if(t instanceof ParameterizedType)
        return (Class<?>)((ParameterizedType)t).getRawType();
    if(t instanceof TypeVariable<?>) return erased(((TypeVariable<?>)t).getBounds()[0]);
    if(t instanceof GenericArrayType) return Array.newInstance(
            erased(((GenericArrayType)t).getGenericComponentType()), 0).getClass();
    return erased(((WildcardType)t).getUpperBounds()[0]);
}
/**
 * You may replace this with the MethodUtils.getMethodsListWithAnnotation()
 * you were already using.
 */
private static Set<Method> getRawAnnotatedMethods(
               Class<?> c, Class<? extends Annotation> a) {
    Set<Method> s = new HashSet<>();
    for(; c!=null; c=c.getSuperclass()) {
        for(Method m: c.getDeclaredMethods()) {
            if(m.isAnnotationPresent(a)) s.add(m);
        }
        for(Class<?> ifC: c.getInterfaces()) {
            for(Method m: ifC.getMethods()) {
                if(m.isAnnotationPresent(a)) s.add(m);
            }
        }
    }
    return s;
}