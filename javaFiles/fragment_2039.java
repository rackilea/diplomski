// Use identity matrix so you don't have to worry about lining up the frame buffer texture
spriteBatch.setProjectionMatrix(spriteBatch.getProjectionMatrix().idt());

// Set multiplicative blending for shadows
spriteBatch.setBlendFunction(GL20.GL_ZERO, GL20.GL_SRC_COLOR); 

spriteBatch.begin();
spriteBatch.draw(frameBuffer.getColorBufferTexture(), -1, 1, 2, -2); //dimensions for full screen with identity matrix
spriteBatch.end();