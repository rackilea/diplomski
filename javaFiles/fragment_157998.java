// Create a backup of the original transform
AffineTransform oldAT = g.getTransform();

// Apply some transformations
g.scale(3.0, 4.0);
g.translate(10.0, 20.0);

// Do custom painting the the transformed graphics
paintSomething(g):

// Restore the original transformation
g.setTransform(oldAT);