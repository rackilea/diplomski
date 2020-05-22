Gdx.gl.glClear(GL_STENCIL_BUFFER_BIT);
batch.end();
//disable color mask
Gdx.gl.glColorMask(false, false, false, false);
Gdx.gl.glDepthMask(false);
//enable the stencil
Gdx.gl.glEnable(GL20.GL_STENCIL_TEST);
Gdx.gl.glStencilFunc(GL20.GL_ALWAYS, 0x1, 0xffffffff);
Gdx.gl.glStencilOp(GL_REPLACE, GL_REPLACE, GL_REPLACE);

batch.begin();
//draw the mask
mask.draw(batch, x + innerButtonTable.getX(), y
        + innerButtonTable.getY(), innerButtonTable.getWidth(),
        innerButtonTable.getHeight());

batch.end();
batch.begin();

//enable color mask 
Gdx.gl.glColorMask(true, true, true, true);
Gdx.gl.glDepthMask(true);
//just draw where outside of the mask
Gdx.gl.glStencilFunc(GL_NOTEQUAL, 0x1, 0xffffffff);
Gdx.gl.glStencilOp(GL_KEEP, GL_KEEP, GL_KEEP);
//draw the destination texture
super.draw(batch, x, y, width, height);
batch.end();
//disable the stencil
Gdx.gl.glDisable(GL20.GL_STENCIL_TEST);