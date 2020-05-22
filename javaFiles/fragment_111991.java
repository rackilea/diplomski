public static <T> void method(List<T> objects, Class<T> clazz) throws Exception {
    for (int i = 0; i < objects.size(); i++) {
        // Create new object of the same class
        T obj = clazz.newInstance();
    }
}