// draw the cube   
gl.glPushMatrix();
{
  gl.glTranslatef( 0.0f, 0.0f, 0.0f );
  gl.glEnableClientState( GL10.GL_VERTEX_ARRAY );
  gl.glVertexPointer( 3, GL10.GL_FLOAT, 0, vertexBuffer );
  gl.glDrawElements( GL10.GL_TRIANGLES, cubeIndices.length, GL10.GL_UNSIGNED_SHORT, indexBufferCube );
  gl.glDisableClientState( GL10.GL_VERTEX_ARRAY );
}
gl.glPopMatrix()

// draw the plane
gl.glPushMatrix();
{
  gl.glTranslatef( 0.0f, 0.0f, 0.0f );
  gl.glScalef( 2f, 2f, 2f ); // make the plane 2x bigger
  gl.glEnableClientState( GL10.GL_VERTEX_ARRAY );
  gl.glVertexPointer( 3, GL10.GL_FLOAT, 0, vertexBufferPlane );
  gl.glDrawElements( GL10.GL_TRIANGLES, planeIndices.length, GL10.GL_UNSIGNED_SHORT, indexBufferPlane );
  gl.glDisableClientState( GL10.GL_VERTEX_ARRAY );
}
gl.glPopMatrix()