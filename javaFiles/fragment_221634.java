private final Map<String, TaskFactory> factoriesMap = new HashMap<>();

void registerFactory(String identifier, TaskFactory factory) {
    factoriesMap.put(identifier, factory);
}

public Task create(String identifier) {
    return factoriesMap.get(identifier).create();
}