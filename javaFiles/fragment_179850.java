public void yourDrawingMethod(Graphics gg)
{
    /* Cast it to Graphics2D */
    Graphics2D g = (Graphics2D) gg;

    /* Enable anti-aliasing and pure stroke */
    g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    g.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);

    /* Construct a shape and draw it */
    Ellipse2D.Double shape = new Ellipse2D.Double(0.5, 0.5, 50, 50);
    g.draw(shape);
}