Predicate<Entity> isSuccessful = new Predicate<Entity>() {
    public boolean apply(Entity e) {
        return e.isSuccessful();
    }
};

Collection<Entity> successfulEntities = filter(entities, isSuccessful);