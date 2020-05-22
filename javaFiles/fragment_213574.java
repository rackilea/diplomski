@SuppressWarnings("unchecked")
<T> T doMethod(Method m, Class<T> returnType, Object Args ...) {
    Object obj = m.getDeclaringClass().getConstructor().newInstance();
    return (T) m.invoke(obj, args);
}

String result = doMethod(m, m.getReturnType(), "Hello");