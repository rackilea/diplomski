class Foo<T> {
    final Class<T> typeParameterClass;

    public Foo(Class<T> typeParameterClass) {
        this.typeParameterClass = typeParameterClass;
    }

    public void bar() {
        // you can access the typeParameterClass here and do whatever you like
    }
}