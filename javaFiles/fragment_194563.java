@Override
public void paintComponent(Graphics g){
    super.paintComponent( g );

    Graphics2D g2=(Graphics2D)g.create();
    int h = getHeight();
    int w = getWidth();

    g2.setComposite(AlphaComposite.getInstance(
            AlphaComposite.SRC_OVER, .5f));
    g2.setPaint(new GradientPaint(0, 0, Color.yellow, 0, h, Color.red));
    g2.fillRect(0, 0, w, h);

    g2.dispose();
}