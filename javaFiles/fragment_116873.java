public void processObject(Map<?, ?> map, Class<Type> cls) {
    // Uses the no-args constructor of Type to create a new instance
    Type item = cls.newInstance();

    // ...
}