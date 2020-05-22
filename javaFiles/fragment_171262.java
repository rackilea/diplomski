@Override
public void render(float delta) {

    camera.update();

    mapRenderer.setView(camera);
    mapRenderer.render();

    batch.setProjectionMatrix(camera.combined);
    batch.begin();
    player.draw(batch);
    batch.end();
}