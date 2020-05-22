private <T> List<T> getEntityList(EntityCreator<T> creator, int numberOfItems) {
    List<T> entities = new ArrayList<T>();

    for (int i = 0; i < numberOfItems; i++) {
        entities.add(creator.create(i));
    }

    return entities;
}