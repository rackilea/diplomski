class A {

    private final int value;

    public static <T extends Builder<T>> T builderA() {
        return (T)new Builder<>();
    }

    protected A(Builder<? extends Builder<?>> builder) {
        value = builder.value;
    }

    public static class Builder<T extends Builder<T>> {

        private int value;

        public T withValue(int value) {
            this.value = value;
            return (T)this;
        }

        public A build() {
            return new A(this);
        }
    }
}

class B extends A {

    private final String name;

    public static <T extends Builder<T>> T builderB() {
        return (T)new Builder<>();
    }

    protected B(Builder<? extends Builder<?>> builder) {
        super(builder);
        name = builder.name;
    }

    public static class Builder<T extends Builder<T>> extends A.Builder<T> {

        private String name;

        public Builder<T> withName(String name) {
            this.name = name;
            return this;
        }

        public B build() {
            return new B(this);
        }
    }
}