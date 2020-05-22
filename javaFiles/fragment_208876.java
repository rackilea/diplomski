protected LinkedList<GameObject> object = new LinkedList<GameObject>();

public void addObject(GameObject object) {
    this.object.add(object);
}

public void remove(GameObject object) {
    this.object.remove(object);
}