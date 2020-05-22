class Super() {
    private static Map<Class<? extends Super, MyType> map = new ...;

    protected Super(MyType value) {
        if (!map.contains(getClass())) {
            map.put(getClass(), value);
        } else {
            assert map.get(getClass(), value) == value;
        }
    }
}