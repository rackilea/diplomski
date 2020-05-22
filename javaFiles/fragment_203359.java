GameObject[] gameObjects = new GameObject[] {new Menu(), new Player()};
drawAll(gameObjects);

...

private void drawAll(GameObject[] gameObjects) {
    for (GameObject gameObject : gameObjects) {
        gameObject.draw();
    }
}