public void foo(String classType) {
    Supplier<? extends MyClassParent> factory = factories.get(classType);
    if (factory != null) {
        MyClassParent instance = factory.get();

        // work with instance
    }
}