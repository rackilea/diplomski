public <T> Collection<T> getAllPeopleByClass(Class<T> clazz) {
    Collection<T> peopleCollection = new ArrayList<T>();
    for(people p : getList(clazz)) {
      peopleCollection.add(clazz.cast(p));
    }
    return peopleCollection;
}