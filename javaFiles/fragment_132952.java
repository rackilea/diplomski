public synchronized void display(GLAutoDrawable drawable) {

    BufferedImage baseImage = frames.poll();        
    if(baseImage == null)return;

    final GL2 gl = drawable.getGL().getGL2(); 
    gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);


     // Create a TextureData and Texture from it
    TextureData textureData = AWTTextureIO.newTextureData(gl.getGLProfile(), baseImage, false);
    Texture texture = TextureIO.newTexture(textureData);
    // Now draw one quad with the texture
    texture.enable(gl);
    texture.bind(gl);
    gl.glTexEnvi(GL2.GL_TEXTURE_ENV, GL2.GL_TEXTURE_ENV_MODE, GL2.GL_REPLACE);
    TextureCoords coords = texture.getImageTexCoords();
    gl.glBegin(GL2.GL_QUADS);
    gl.glTexCoord2f(coords.left(), coords.bottom());
    gl.glVertex3f(0, 0, 0);
    gl.glTexCoord2f(coords.right(), coords.bottom());
    gl.glVertex3f(1, 0, 0);
    gl.glTexCoord2f(coords.right(), coords.top());
    gl.glVertex3f(1, 1, 0);
    gl.glTexCoord2f(coords.left(), coords.top());
    gl.glVertex3f(0, 1, 0);
    gl.glEnd();
    texture.disable(gl);


    texture.destroy(gl);
    //baseImage = null;
}