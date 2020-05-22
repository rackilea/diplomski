public boolean areAllAlive(Entity[] entities) {
    if(entities == null || entities.length == 0) {
        return false; //?
    }
    for(Entity e : entities) {
       if(!e.isAlive()) {
          return false;
       }
    } 
    return true;
}