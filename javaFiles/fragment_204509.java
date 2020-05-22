public Set<Class<?>> getAnnotatedEndpointClasses(Set<Class<?>> scanned) {
    // Deploy all WebSocket endpoints defined by annotations in the examples
    // web application. Filter out all others to avoid issues when running
    // tests on Gump
    Set<Class<?>> results = new HashSet<>();
    for (Class<?> clazz : scanned) {
        String name = clazz.getPackage().getName();
        boolean ok = name.startsWith("websocket.");
        if (ok) {
            results.add(clazz);
        }
    }
    return scanned;
}