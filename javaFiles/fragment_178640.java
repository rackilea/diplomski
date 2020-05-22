// Compute the scale
double xscale;
Double scale = this.getActiveAttributes().getScale();
if (scale != null)
    xscale = scale * this.activeTexture.getWidth(dc);
else
    xscale = this.activeTexture.getWidth(dc);

double yscale;
if (scale != null)
    yscale = scale * this.activeTexture.getHeight(dc);
else
    yscale = this.activeTexture.getHeight(dc);
double maxwh = Math.max(xscale, yscale);

// The image is drawn using a parallel projection.
osh.pushProjectionIdentity(gl);
gl.glOrtho(0d, dc.getView().getViewport().width, 0d, dc.getView().getViewport().height, -0.6 * maxwh, 0.6 * maxwh);