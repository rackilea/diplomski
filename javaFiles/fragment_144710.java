...
private Class<?> definingClass(Class<?> clz, String method) throws NoSuchMethodException, SecurityException {
    Method m = clz.getMethod(method);
    return m.getDeclaringClass();
}

...

System.err.println(definingClass(A.class, "toString"));
System.err.println(definingClass(B.class, "toString"));
System.err.println(definingClass(C.class, "toString"));
System.err.println(definingClass(D.class, "toString"));

...