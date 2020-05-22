for (int i = 0; i < size; i++) {
    Vector2 location = groundLocations.get(i);
    if (location.x < cameraLeft) {

        location.x = findMax().x + textureWidth;
    }          
    location.x -= delta * speed;

}