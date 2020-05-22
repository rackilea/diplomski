public void paintComponent(Graphics context) {
    super.paintComponent(context);
    Graphics2D g = (Graphics2D)context.create();

    AffineTransform trans = new AffineTransform();

    int height = getHeight();
    int width = getWidth();

    trans.scale(width/4.0, height/7.0);
    g.transform(trans);

    try {
        g.setStroke(new TransformedStroke(new BasicStroke(2f),
                                          trans));
    }
    catch(NoninvertibleTransformException ex) {
        // should not occur if width and height > 0
        ex.printStackTrace();
    }

    g.setColor(Color.BLACK);
    g.draw(new Rectangle( 1, 2, 2, 4));
}