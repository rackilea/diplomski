// Set the color of the Shape.
g2.setColor(Color.BLACK);
// Backup the transformation matrix so we can restore it later.
AffineTransform backupTransform = new AffineTransform(g2.getTransform());
// Translate everything that is drawn afterwards by the given coordinates.
// (This will be the new position of the center of the Shape)
g2.translate(53, 27);
// Draw the Shape.
g2.draw(shape);
// Restore the old transform, so that things drawn after this line
// are not affected by the translation.
g2.setTransform(backupTransform);