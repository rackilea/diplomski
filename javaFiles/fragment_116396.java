protected void paintComponent(Graphics gr) {
    super.paintComponent(gr);
    Graphics2D g = (Graphics2D)gr;
    ...

    // Obtain an AffineTransform that describes a scaling
    AffineTransform scalingTransform =      
        AffineTransform.getScaleInstance(2,2);

    // Apply the transform to the graphics
    g.transform(scalingTransform );

    // Draw a rectangle. 
    g.drawRect(0,0,50,100);
}