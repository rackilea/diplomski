private static void test(Class<?>... classes) {
    System.out.println("Common ancestor for "
            + simpleClassList(Arrays.asList(classes)) + ", Result =>  "
            + simpleClassList(commonSuperClass(classes)));
}

private static String simpleClassList(Collection<Class<?>> classes) {
    StringBuilder builder = new StringBuilder();
    for (Class<?> clazz : classes) {
        builder.append(clazz.getSimpleName());
        builder.append(",");
    }
    return builder.toString();
}

public static void main(String[] args) {
    test(A.class, AImpl.class);
    test(A.class, B.class, C.class);
    test(A.class, AB.class);
    test(AImpl.class, ABImpl.class);
    test(ABImpl.class, ABImpl2.class);
    test(AImpl.class, ABImpl.class, ABImpl2.class);
    test(ABImpl.class, ABImpl2.class, BCImpl.class);
    test(AImpl.class, ABImpl.class, ABImpl2.class, BCImpl.class);
    test(AB.class, ABImpl.class);
}