private void rotateCameraAroundModel(float angle) {
    camera.position.set(centreX, centerY, centerZ);
    camera.rotate(Vector3.Y, (float) Math.toDegrees(angle)); // Rotate around Y axis by angle in degrees
    float x = (float) (centerX + radius * (Math.sin(totalPhi)));
    float z =  (float) (centerZ + radius * (Math.cos(totalPhi)));
    camera.position.add(x, 0f, z); //Move back out 2m using pythagorean theorem to calculate the position on the circle
    camera.up.set(Vector3.Y);
    camera.lookAt(0, 0, 0);
    camera.update();
}