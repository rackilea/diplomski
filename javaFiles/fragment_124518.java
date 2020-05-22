public static void drawGradientRectangle(GL10 gl, float centerX, float centerY,
            float width, float height) {
        gl.glPushMatrix();
        gl.glDisable(GL10.GL_TEXTURE_2D);
        gl.glEnableClientState(GL10.GL_COLOR_ARRAY);
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY); //just in case if you have not done that before
        gl.glFrontFace(GL10.GL_CCW); //Set the face

        gl.glTranslatef(centerX, centerY, 0);
        if (width != 1 || height != 1) {
            gl.glScalef(width, height, 1);
        }
        gl.glVertexPointer(2, GL10.GL_FLOAT, 0, GLDrawConstants.vertexBuffer0_5);
        gl.glColorPointer(4, GL10.GL_FLOAT, 0, GLDrawConstants.gradOrangeWhiteBuffer);

        // Draw the vertices as triangle strip
        gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 0, 4);

        gl.glDisableClientState(GL10.GL_COLOR_ARRAY);
        gl.glEnable(GL10.GL_TEXTURE_2D);
        gl.glPopMatrix();
    }