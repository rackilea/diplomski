Graphics2D g2d = (Graphics2D) g.create();
g2d.setColor(Color.blue);

Rectangle tangle = new Rectangle(0, 0, radius, radius);
g2d.translate(centerX, centerY);
g2d.rotate(Math.toRadians(curAngle));
g2d.draw(tangle);
curAngle += angle;
g2d.dispose();