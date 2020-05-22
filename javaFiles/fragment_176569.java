public boolean areAllAlive(Entity[] entities) {
    if(entities == null || entities.length == 0) {
        return false; //?
    }
    return Arrays.stream(entities).allMatch(e -> e.isAlive());
}