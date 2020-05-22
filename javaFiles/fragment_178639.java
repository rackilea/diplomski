double width = this.getScaledIconWidth();
double height = this.getScaledIconHeight();

// Load a parallel projection with xy dimensions (viewportWidth, viewportHeight)
// into the GL projection matrix.
java.awt.Rectangle viewport = dc.getView().getViewport();
ogsh.pushProjectionIdentity(gl);
double maxwh = width > height ? width : height;
if (maxwh == 0)
    maxwh = 1;
gl.glOrtho(0d, viewport.width, 0d, viewport.height, -0.6 * maxwh, 0.6 * maxwh);