protected void draw(GLAutoDrawable gLDrawable) {
    // each sprite has a different blending function.
    changeBlendingFunc(gLDrawable);

    // getting the quad as an array of length 4, containing vectors
    Vector[] bb = getQuadBillboard();
    GL gl = gLDrawable.getGL();

    // getting the texture
    getTexture().bind();

    // getting the colors
    float[] rgba = getRGBA();
    gl.glColor4f(rgba[0],rgba[1],rgba[2],rgba[3]);

    //draw the sprite on the computed quad
    gl.glBegin(GL.GL_QUADS);
    gl.glTexCoord2f(0.0f, 0.0f); gl.glVertex3d(bb[0].x, bb[0].y, bb[0].z);
    gl.glTexCoord2f(1.0f, 0.0f); gl.glVertex3d(bb[1].x, bb[1].y, bb[1].z);
    gl.glTexCoord2f(1.0f, 1.0f); gl.glVertex3d(bb[2].x, bb[2].y, bb[2].z);
    gl.glTexCoord2f(0.0f, 1.0f); gl.glVertex3d(bb[3].x, bb[3].y, bb[3].z);
    gl.glEnd();
}