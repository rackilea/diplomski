@Override
public void display(GLAutoDrawable glAutoDrawable) {
    GL3 gl = glAutoDrawable.getGL().getGL3();
    gl.glClear(GL3.GL_DEPTH_BUFFER_BIT | GL3.GL_COLOR_BUFFER_BIT);

    gl.glUseProgram(program)
    gl.glBindVertexArray(vertexArray.get(0));
    gl.glDrawArrays(GL.GL_TRIANGLES, 0, 6)
}