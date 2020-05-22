Rectangle rect = circle.getBounds();
Rectangel bounds = getBounds();

if(rect.getX() + rect.getWidth()>bounds.getWidth()){
    //draw an ellipse that is offset by the width of the component.
    Ellipse2D c2 = new Ellipse2D.Double(circle.getX()-bounds.getWidth(), circle.getY(), circle.getWidth(), circle.getHeight());    
    g2.fill(c2);
}