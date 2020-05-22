void checkMap(Long n) {
    final Set<Map.Entry<Long, Long>> mapValues = server.entrySet();
    Set<Map.Entry<Long, Long>> entries = new LinkedHashSet<>(mapValues);

    for (Entry<Long, Long> entry : entries) {
        assertNotNull(entry);
    }
}