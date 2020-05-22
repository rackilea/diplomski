public void onDrawFrame(GL10 unused) {
// Redraw background color

GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
mTriangle.draw();

}