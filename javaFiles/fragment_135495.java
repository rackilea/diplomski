// Reference to the image's Graphics context
Graphics offgc;
// Backing image
Image offscreen = null;
// Current size of the component
Dimension d = size();

// create the offscreen buffer and associated Graphics
offscreen = createImage(d.width, d.height);
// Get a reference to the backing buffer's Graphics context
offgc = offscreen.getGraphics();

// The image has a default color (black I think), so we
// fill it with components current background color
// clear the exposed area  ----------- T H I S    B L O C K --------
offgc.setColor(getBackground());
offgc.fillRect(0, 0, d.width, d.height);
// Set the default color to the foreground color
offgc.setColor(getForeground());

// do normal redraw
paint(offgc);
// transfer offscreen to window
g.drawImage(offscreen, 0, 0, this);