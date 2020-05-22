// save the original transform so that it can be restored later
AffineTransform oldTransform = g2d.getTransform();
g2d.scale(zoom, zoom);
...
// use g2d normally
...
// restore the transform because the same Graphics2D object
// might be used to draw other components
g2d.setTransform(oldTransform );