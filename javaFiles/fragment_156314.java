CopyOnWriteArrayList<Entity> entities = new CopyOnWriteArrayList<Entity>();

public void deleteEntities() {
    for(Entity entity: entities){
        Body body = entity.getBody();
        if (body != null) {
            EntityData data = (EntityData) body.getUserData();
            if (data.isFlaggedForDelete()) {
                final Array<JointEdge> list = body.getJointList();
                //delete all joints attached
                while (list.size > 0) {
                    myWorld.getWorld().destroyJoint(list.get(0).joint);
                }
                //nullify everything, remove the entity from entities and destroy the body
                body.setUserData(null);
                myWorld.getWorld().destroyBody(body);
                entities.remove(entity);
                body = null;                    
            }
        }
    }
}