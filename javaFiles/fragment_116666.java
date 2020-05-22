public void checkEntity(Entity entity) {
    for (Entity candidate : entities) {
        if (candidate.getID() == entity.getID()) {
            candidate.setXPos(entity.getXPos());
            candidate.setYPos(entity.getYPos());
            // Found a matching entity, so we're done now.
            // This is important, so we don't add the entity again.
            return;
        }
    }
    // Haven't found it, so add it to the list
    entities.add(entity);
}