public static void getClassToWrap(Class<?> cls) {
    try {
        Object obj = cls.newInstance();
        obj = "helloWorld";
        Method reflectedMethod = cls.getDeclaredMethod("hashCode");
        System.out.println(reflectedMethod.invoke(obj));
    } catch (Exception ex) {
        System.out.println("stack trace");
        ex.printStackTrace();
    }
}