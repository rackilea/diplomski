@Override
public boolean replicate(Entity entity) {
    if (entity.getClass() == ConcreteEntity.class) {
        // replicating logic
        return true;
    }
    return false;
}