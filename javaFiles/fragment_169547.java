class MyClass<PK> {
    private final Class<PK> keyClass;
    MyClass(Class<PK> keyClass) {
         this.keyClass = keyClass;
    }

    PK getKey() {
        return keyClass.cast(...);
    }
}