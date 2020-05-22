// front
    gl.glPushMatrix();
    gl.glTranslatef(0.0f, 0.0f, 1.0f);
    gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 0, 4);
    gl.glPopMatrix();

    // left
    gl.glPushMatrix();
    gl.glRotatef(270.0f, 0.0f, 1.0f, 0.0f);
    gl.glTranslatef(0.0f, 0.0f, 1.0f);
    gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 4, 4);
    gl.glPopMatrix();

    // back
    gl.glPushMatrix();
    gl.glRotatef(180.0f, 0.0f, 1.0f, 0.0f);
    gl.glTranslatef(0.0f, 0.0f, 1.0f);
    gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 8, 4);
    gl.glPopMatrix();

    // right
    gl.glPushMatrix();
    gl.glRotatef(90.0f, 0.0f, 1.0f, 0.0f);
    gl.glTranslatef(0.0f, 0.0f, 1.0f);
    gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 12, 4);
    gl.glPopMatrix();

    // top
    gl.glPushMatrix();
    gl.glRotatef(270.0f, 1.0f, 0.0f, 0.0f);
    gl.glTranslatef(0.0f, 0.0f, 1.0f);
    gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 16, 4);
    gl.glPopMatrix();

    // bottom
    gl.glPushMatrix();
    gl.glRotatef(90.0f, 1.0f, 0.0f, 0.0f);
    gl.glTranslatef(0.0f, 0.0f, 1.0f);
    gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 20, 4);
    gl.glPopMatrix();