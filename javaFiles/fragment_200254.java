// To move forward
camera.position.add(camera.direction.scl(1f));
camera.update();

// To move backwards
camera.position.sub(camera.direction.scl(1f));
camera.update();

// To move to the right
Vector3 right = camera.direction.cpy().crs(Vector3.Y).nor();
camera.position.add(right.scl(1));
camera.update();

// To move to the left
Vector3 right = camera.direction.cpy().crs(Vector3.Y).nor();
camera.position.sub(right.scl(1));
camera.update();