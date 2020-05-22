class EntityResolver {

    private Map<Integer, Entity> entities;

    public EntityResolver(EntitiesOwner[] owners) {
        entities = new HashMap<Integer, Entity>(owners.length);
        for (EntitiesOwner owner : owners) {
            for (Entity entity : owner.getEntities()) {
                entities.put(entity.getId(), entity);
            }
        }
    }

    public Entity getById(int id) {
        return entities.get(id);
    }
}