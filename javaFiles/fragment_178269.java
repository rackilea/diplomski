public void render() {
    Gdx.gl.glClearColor(0, 0, 0, 1);
    Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

    rectangle.width = 5; // Change this line while debugging.
    rectangle.height = 10;

    shapeRenderer.setProjectionMatrix(camera.combined);
    shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
    shapeRenderer.setColor(1, 1, 0, 1);
    shapeRenderer.rect(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
    shapeRenderer.end();

    camera.update(); // only if we're moving the screen though
}