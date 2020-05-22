public <T> Optional<T> fetch(Class<T> clazz, Object id, String... relations) {
    EntityGraph<T> graph = entityManager.createEntityGraph(clazz);
    Stream.of(relations).forEach(path -> {
        String[] splitted = path.split("\\.");
        Subgraph<T> root = graph.addSubgraph(splitted[0]);
        for (int i = 1; i < splitted.length; i++)
            root = root.addSubgraph(splitted[i]);
    });
    return Optional.ofNullable(entityManager.find(clazz, id, Collections.singletonMap("javax.persistence.loadgraph", graph)));
}