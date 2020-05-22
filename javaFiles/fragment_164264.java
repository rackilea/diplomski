public static <T> Object[] multipleConstructor(Class<T> type,
        Object[]... initargs) {
    ArrayList<T> list = new ArrayList<>();
    @SuppressWarnings("unchecked")
    Constructor<T>[] ctors = (Constructor<T>[]) type.getConstructors();
    for (int i = 0; i < initargs.length; i++) {
        for (Constructor<T> c : ctors) {
            try {
                list.add(c.newInstance(initargs[i]));
                break;
            } catch (Throwable t) {
                continue;
            }
        }
    }
    return list.toArray();
}