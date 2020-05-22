Rectangle rect = new Rectangle(0, 0, 10, 10);

AffineTransform at = new AffineTransform();
at.rotate(Math.toRadians(45));

Shape rotatedRect = at.createTransformedShape(rect);