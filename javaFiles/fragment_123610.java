...
double fovyInDegrees = 50; // Change this if you want.
double ymax, xmax, aspectRatio;
aspectRatio = OpenGL.WIDTH / OpenGL.HEIGHT;
ymax = znear * Math.tan(fovyInDegrees * Math.PI / 360);
xmax = ymax * aspectRatio;
GL11.glFrustum(-xmax, xmax, -ymax, ymax, znear, zfar);
...