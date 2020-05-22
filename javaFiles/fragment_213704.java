gl.glMatrixMode(GL2.GL_PROJECTION);
gl.glLoadIdentity();

float widthHeightRatio = (float) getWidth()/ (float) getHeight();

glu.gluPerspective(Camera.FOV, widthHeightRatio, 1, Camera.ViewDistance);

glu.gluLookAt(Camera.Location.x, Camera.Location.y, Camera.Location.z, 
                            Camera.Location.x+Camera.ViewPort.x, Camera.Location.y+Camera.ViewPort.y, Camera.Location.z+Camera.ViewPort.z,
                            0, 1, 0);

gl.glMatrixMode(GL2.GL_MODELVIEW);
gl.glLoadIdentity();