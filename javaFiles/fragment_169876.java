float alpha = 0.0f;

public void paint(Graphics g) {
    Graphics2D g2d = (Graphics2D) g;

    //set the opacity
    g2d.setComposite(AlphaComposite.getInstance(
            AlphaComposite.SRC_OVER, alpha));
    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);

    //do the drawing here
    g2d.drawLine(10, 10, 110, 110);
    g2d.drawRect(10, 10, 100, 100);

    //increase the opacity and repaint
    alpha += 0.05f;
    if (alpha >= 1.0f) {
        alpha = 1.0f;
    } else {
        repaint();
    }

    //sleep for a bit
    try {
        Thread.sleep(200);
    } catch (InterruptedException e) {

        e.printStackTrace();
    }
}