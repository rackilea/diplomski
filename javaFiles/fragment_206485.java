protected MapObject getCellProperties(int layerIndex) {
    MapObjects mapObjects = map.getLayers().get(layerIndex).getObjects();

    for (MapObject mapObject : mapObjects) {
        MapProperties mapProperties = mapObject.getProperties();

        float width, height, x, y;
        Rectangle objectRectangle = new Rectangle();
        Rectangle playerRectangle = new Rectangle();

        if (mapProperties.containsKey("width") && mapProperties.containsKey("height") && mapProperties.containsKey("x") && mapProperties.containsKey("y")) {
            width = (float) mapProperties.get("width");
            height = (float) mapProperties.get("height");
            x = (float) mapProperties.get("x");
            y = (float) mapProperties.get("y");
            objectRectangle.set(x, y, width, height);
        }

        playerRectangle.set(
                playScreen.getPlayer().getX() * MainGameClass.PPM,
                playScreen.getPlayer().getY() * MainGameClass.PPM,
                playScreen.getPlayer().getWidth() * MainGameClass.PPM,
                playScreen.getPlayer().getHeight() * MainGameClass.PPM
        );

        // If the player rectangle and the object rectangle is colliding, return the object
        if (Intersector.overlaps(objectRectangle, playerRectangle)) {
            return mapObject;
        }
    }

    // If no colliding object was found in that layer
    return null;
}