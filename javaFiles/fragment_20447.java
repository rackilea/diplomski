public static <T extends Shape> void drawWithShadow(T shape, Class<T> shapeClass) {
    // The shadow must be the same shape as what's passed in
    T shadow = shapeClass.newInstance();
    // Set the shadow's properties to from the shape...
    shadow.draw(); // First, draw the shadow
    shape.draw();  // Now draw the shape on top of it
}