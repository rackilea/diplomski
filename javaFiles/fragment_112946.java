public <T extends Collection<String>> T addToCollection(String object, T collection, Class<T> clazz) {
if (collection == null)
    collection = clazz.newInstance();

collection.add(object);

return collection;
}