@Override
public void paintComponent(Graphics g){
    super.paintComponent( g );

    Graphics2D g2=(Graphics2D)g.create();
    int h = getHeight();
    int w = getWidth();

    g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, .5f));


    Point2D center = new Point2D.Float(100, 50);
    float radius = 150;
    float[] dist = {0.0f, 1.0f};

    Color[] colors = {Color.yellow, Color.red};
    RadialGradientPaint p = new RadialGradientPaint(center, radius, dist, colors);
    g2.setPaint(p);     

    g2.fillRect(0, 0, w, h);

    g2.dispose();       

}