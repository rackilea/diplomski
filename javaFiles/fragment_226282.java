public static <T extends A> T construct(Class<T> tClass) {
    T t = tClass.newInstance();
    t.doStuff();
    moreStuff();
    return t;
}