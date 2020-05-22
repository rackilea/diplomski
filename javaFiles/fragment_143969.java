public int compare(Entity e1, Entity e2) {
    if (e1 == e2) {
        return 0;
    }
    if (e1 == null) {
        return -1;
    }
    if (e2 == null) {
        return 1;
    }
    Vector2 e1Pos = Mapper.transform.get(e1).position;
    Vector2 e2Pos = Mapper.transform.get(e2).position;
    return ...;
}