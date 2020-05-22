Gdx.gl.glEnable(GL20.GL_BLEND);
    Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
    shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
    shapeRenderer.setColor(new Color(0, 0, 0, 0.5f));
    shapeRenderer.rect(0, 0, screenWidth, screenHeight);
    shapeRenderer.end();
    Gdx.gl.glDisable(GL20.GL_BLEND);