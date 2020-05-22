Graphics2D g2d = (Graphics2D)g;
AffineTransform transform = g2d.getTransform();

g2d.rotate(angle, centerX, centerY);

g2d.fillRect(...); // draw your rectangle

g2d.setTransform(transform);