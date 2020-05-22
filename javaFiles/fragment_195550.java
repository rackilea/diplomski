public <E extends Entity> List<E> getEntities(Class<E> type) {

    List<E> list = new ArrayList<>();

    for (Entity e : entities) {
        if (type.isInstance(e)) {
            list.add(type.cast(e));
        }
    }

    return Collections.unmodifiableList(list);
}