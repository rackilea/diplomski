public Entity createEntity(Class<? extends Component>... types){
    Entity e = new Entity();  
    for(Class<? extends Component> type: types)
        addNewComponentInstance(type, e.UID);                   
    INDEX.add(e.UID, e);
    return e;
}