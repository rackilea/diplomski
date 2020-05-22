frameBuffer.begin();
Gdx.gl.glClearColor(/* ... */); // This will be your ambient color, a dark color, like gray
Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

spriteBatch.setProjectionMatrix(camera.combined); // same camera as your game scene
spriteBatch.setBlendFunction(GL20.GL_ONE, GL20.GL_ONE); //additive blending
spriteBatch.begin();

// draw light sprites, such as a white circle where your character is standing

spriteBatch.end();
frameBuffer.end();