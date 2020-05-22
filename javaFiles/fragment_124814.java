public <T> void saveObjectKey(String filename, Long start, Class<T> clazz, String keyName) {
    Query<T> query = datastore.createQuery(clazz).field(keyName).greaterThan(start);
    for (T o : query.fetch()) {
        Util.writeFile(o.getPrimaryKey().toString(), filename);
    }
}