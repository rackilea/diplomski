private boolean shallPaint = false;

public void paintComponent(Graphics g) {
    super.paintComponent(g);
    if (shallPaint) {
        Graphics2D g2D = (Graphics2D) g;
        rectangle = new Rectangle2D.Double(0, 260-score1 * 2, 25, score1 * 2);
        g2D.setPaint(Color.blue); 
        g2D.fill(rectangle);
        g2D.draw(rectangle);              
    }
}

public void setShallPaint(boolean pShallPaint) {
    shallPaint  = pShallPaint;
}