@Override
    public void mouseDragged(final MouseEvent theEvent) {
        myXEnd = theEvent.getX();
        myYEnd = theEvent.getY();
        repaint(); 
    }

    @Override
    public void mousePressed(final MouseEvent theEvent) {
        myX = theEvent.getX();
        myY = theEvent.getY();
    }

    @Override
    public void mouseReleased(final MouseEvent theEvent) {
        myXEnd = theEvent.getX();
        myYEnd = theEvent.getY();
        myLines.add(new Line2D.Double(myX, myY, myXEnd, myYEnd));
        repaint();            
    }
};

/**
 * Draws line with drawLine method.
 */
@Override
public void paintComponent(final Graphics theGraphics) {
    super.paintComponent(theGraphics);
    final Graphics2D g2d = (Graphics2D) theGraphics;

    // for better graphics display
    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                         RenderingHints.VALUE_ANTIALIAS_ON);

    g2d.setPaint(new Color(51, 0, 111));
    g2d.setStroke(new BasicStroke(STROKE_WIDTH));

    g2d.draw(new Line2D.Double(myX, myY, myXEnd, myYEnd));

    for (Line2D l : myLines) {
        g2d.draw(l);
    }  
}