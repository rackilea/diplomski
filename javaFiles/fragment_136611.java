glMatrixMode(GL_PROJECTION);
 glLoadIdentity(); 
 gluPerspective(50.0, 1.0, 3.0, 7.0); 
 glMatrixMode(GL_MODELVIEW);
 glLoadIdentity(); 
 gluLookAt(0.0, 0.0, 5.0,
           0.0, 0.0, 0.0,
           0.0, 1.0, 0.0);