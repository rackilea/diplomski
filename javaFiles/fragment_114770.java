...

    Gdx.gl.glClearColor(0, 0, 0, 1);
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

    this.viewport.update(this.screenWidth, this.screenHeight);
    this.stage.act();
    this.stage.draw();