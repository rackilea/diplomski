public boolean collectionExists(final String collectionName) {
    Set<String> collectionNames = getCollectionNames();
    for (final String name : collectionNames) {
        if (name.equalsIgnoreCase(collectionName)) {
            return true;
        }
    }
    return false;
}