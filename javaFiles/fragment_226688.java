class GenericClass<T> {

    Class<T> clazz;

    public GenericClass(Class<T> c) {
        clazz = c;
    }

    protected void doStuff() {
        methodToCall(clazz);
    }

}