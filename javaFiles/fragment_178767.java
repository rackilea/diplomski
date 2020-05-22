class Pojo<T> {
    private Class<?> clazz;
    Pojo(Class<?> clazz) {
        this.clazz = clazz;
    }
    void doSomething(T arg1, Object arg2) {
        if (!clazz.isInstance(arg2)) {
            throw new ClassCastException();
        }
        ...
    }
}