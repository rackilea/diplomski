void paintSomething(Graphics2D g) {
    ...
    // Draw some shape in its normal size
    g.draw(someShape);

    // Create a scaling transform
    AffineTransform at = AffineTransform.getScaleInstance(3.0, 3.0);

    // Create a scaled version of the shape
    Shape transformedShape = at.createTransformedShape(someShape);

    // Draw the scaled shape
    g.draw(transformedShape);
}