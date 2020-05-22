protected <T extends IObject> List<T> getObjects() {
    List<T> objects = new ArrayList<T>();
    for (String id: item_ids)
    {
        T object = (T) readObject(id);
        objects.add(object); // NO error
    }
    return objects;
}