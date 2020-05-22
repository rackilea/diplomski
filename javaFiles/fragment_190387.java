double myX = ..., myY = ..., myZ = ...; // your object's 3d coordinates
double[] my2DPoint = new double[2]; // will contain 2d window coords when done

double[] modelview = new double[16];
double[] projection = new double[16];
int[] viewport = new int[4];

gl.glGetDoublev(GL2.GL_MODELVIEW_MATRIX, modelview, 0);
gl.glGetDoublev(GL2.GL_PROJECTION_MATRIX, projection, 0);
gl.glGetIntegerv(GL2.GL_VIEWPORT, viewport, 0);
glu.gluProject(myX, myY, myZ, modelview, 0, projection, 0,
               viewport, 0, my2DPoint, 0);

// now my2DPoint[0] is window x, and my2DPoint[1] is window y