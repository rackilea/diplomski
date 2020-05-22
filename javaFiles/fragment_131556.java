AffineTransform tx = new AffineTransform();
tx.rotate(3.14/5, img.getWidth() / 2, img.getHeight() / 2);

AffineTransformOp op = new AffineTransformOp(tx,
AffineTransformOp.TYPE_BILINEAR);
BufferedImage img2 = op.filter(img, null);

g2.drawImage(img, 0, 0, null);
g2.drawImage(img2, 0, 0, null);
g2.setColor(Color.magenta);
Point2D.Double p2=(Point2D.Double)op.getPoint2D(new Point2D.Double(10, hc/2), null);
g2.fillOval(10, hc/2, 5, 5);
g2.setColor(Color.red);
g2.fillOval((int)p2.x, (int)p2.y, 5, 5);
System.out.println(p2.toString());