Graphics2D g2d = (Graphics2D) g.create();
AffineTransform at = g2d.getTransform();
at.translate(originX, originY);
g2d.setTransform(at);
g2d.scale(scale, scale);
g2d.rotate(Math.toRadians(angle), 0, 0);
g2d.fillRect(xOffset, yOffset, rectWidth, rectHeight);
g2d.dispose();