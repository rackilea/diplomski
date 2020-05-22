gl2.glPushMatrix();     
gl2.glClear( GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT );
/** Try removing the following glLoadIdentity call below.
  * That call was blowing out the MODELVIEW matrix - it's removing your 
  * gluLookAt call and returning to the identity.
  * As a result, the cube will always be right there in front of you.
  */
// gl2.glLoadIdentity();
gl2.glTranslatef(x, y, z);
gl2.glBegin( GL2.GL_QUADS );
gl2.glColor3f( 1, 0, 0 ); //24 glVertex3f calls & some colour changes go here.
gl2.glVertex3f(...)
gl2.glEnd();
gl2.glPopMatrix();