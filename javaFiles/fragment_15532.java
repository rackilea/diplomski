float deltaX = -Gdx.input.getDeltaX() * degreesPerPixel;
float deltaY = -Gdx.input.getDeltaY() * degreesPerPixel;
camera.direction.rotate(camera.up, deltaX);
Vector3 oldPitchAxis = tmp.set(camera.direction).crs(camera.up).nor();
Vector3 newDirection = tmp2.set(camera.direction).rotate(tmp, deltaY);
Vector3 newPitchAxis = tmp3.set(tmp2).crs(camera.up);
if (!newPitchAxis.hasOppositeDirection(oldPitchAxis))
    camera.direction.set(newDirection);