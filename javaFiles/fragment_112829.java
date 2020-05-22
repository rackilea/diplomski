public <T> T get(String key, T... args) {
    return get(key, (Class<T>) args.getClass().getComponentType());
}

public <T> T get(String key, Class<T> clazz) {
    System.out.println("key  : " + key);
    System.out.println("clazz: " + clazz);
}

// using
Boolean b = get("mykey");