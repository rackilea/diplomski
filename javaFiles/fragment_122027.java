//drawing polygon
shapeRenderer.polygon(getPoly().getTransformedVertices());
shapeRenderer.end();

Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
Gdx.gl.glDisable(GL20.GL_BLEND);