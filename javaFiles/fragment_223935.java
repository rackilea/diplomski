AffineTransform tx = new AffineTransform();
tx.rotate(...);

Point2D point = new Point2D.Double(x, y);
Point2D rotated = new Point2D.Double();
tx.transform(point, rotated);