glMatrixMode(GL_PROJECTION);
glLoadIdentity();
glOrtho(-1, 1, -1, 1, -1, 1);
glMatrixMode(GL_MODELVIEW);
glLoadIdentity();
glDisable(GL_DEPTH_TEST);