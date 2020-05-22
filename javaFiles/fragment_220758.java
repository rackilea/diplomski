List<Collision> collisions = getAllCollisions(movingObjects);
for (Collision collision: collisions) {
    for (Moving element: collision.getCollidingObjects) {
        element.handleCollision(collision);
    }
}