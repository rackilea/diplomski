Map<String, AnotherClass> instances = new LinkedHashMap<String, AnotherClass>();
for (...) {
    String name = getNextName();
    AnotherClass instance = instances.get(name);
    if (instance == null) {
        instance = makeInstance(name);
        instances.put(name, instance);
    }
    useInstance(name, instance);
}