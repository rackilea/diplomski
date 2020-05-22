public void render() {
    Store.Graphics.SB.setProjectionMatrix(Store.Camera.Camera.combined);
    Store.Graphics.tiledMapRenderer.render();

    Store.Entity.player.render(Store.Graphics.SB);
}