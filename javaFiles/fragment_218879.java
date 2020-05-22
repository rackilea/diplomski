glMatrixMode(GL_PROJECTION);
glPushMatrix();
glLoadIdentity();
glOrtho(0, width, 0, height, -1.0, 1.0);

glMatrixMode(GL_MODELVIEW);
glPushMatrix();
glLoadIdentity();

//Render stuff in window coordinates here.

glPopMatrix();

glMatrixMode(GL_PROJECTION);
glPopMatrix();