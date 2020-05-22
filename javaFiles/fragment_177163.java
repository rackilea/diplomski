public void display(GLAutoDrawable drawable) {
    final GL2 gl = drawable.getGL().getGL2();
    gl.glBegin (GL2.GL_POINTS);
    double radius = 0.6;//sc.nextDouble();
    double x =0.0;
    double y = radius;
    gl.glVertex2d(0.0,0.0);
    gl.glVertex2d(x,y);
    gl.glVertex2d(-x,y);
    gl.glVertex2d(x,-y);
    gl.glVertex2d(-x,-y);
    gl.glVertex2d(y,x);
    gl.glVertex2d(-y,x);
    gl.glVertex2d(y,-x);
    gl.glVertex2d(-y,-x);

    double eps = .01;
    double eps2 = eps*eps;
    while(x<y){

        y = Math.sqrt(y*y-2*eps*x-eps2);
        x+= eps;
        gl.glVertex2d(x,y);
        gl.glVertex2d(-x,y);
        gl.glVertex2d(x,-y);
        gl.glVertex2d(-x,-y);
        gl.glVertex2d(y,x);
        gl.glVertex2d(-y,x);
        gl.glVertex2d(y,-x);
        gl.glVertex2d(-y,-x);

    }
    gl.glEnd();
}