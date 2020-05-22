public static <T extends SolParent> T make(Class<T> type) throws Exception {
    Constructor<T> constructor = type.getDeclaredConstructor();
    constructor.setAccessible(true);
    T inst = constructor.newInstance();
    inst.showFields();
    return inst;
}