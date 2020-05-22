@Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height)
    {
        super.paintBorder(c, g, x, y, width, height);
        Graphics2D g2d = null;

        if (g instanceof Graphics2D)
        {
            g2d = (Graphics2D) g;

            //Draw border fill (currently hard coded to white, but can be changed)
            g2d.setColor(Color.white);
            //Top
            g2d.fill(new Rectangle2D.Double(0, 0, width, borderThickness));
            //Left
            g2d.fill(new Rectangle2D.Double(0, 0, borderThickness, height));
            //Bottom
            g2d.fill(new Rectangle2D.Double(0, height-borderThickness, width, borderThickness));
            //Right
            g2d.fill(new Rectangle2D.Double(width-borderThickness, 0, borderThickness, height));

            //draw black seperator
            g2d.setColor(borderColour);
            //Top
            g2d.fill(new Rectangle2D.Double(borderThickness, borderThickness, width-(borderThickness*2), 1));
            //Left
            g2d.fill(new Rectangle2D.Double(borderThickness, borderThickness, 1, height-(borderThickness*2)));
            //Bottom
            g2d.fill(new Rectangle2D.Double(borderThickness, height-borderThickness-1, width-(borderThickness*2), 1));
            //Right
            g2d.fill(new Rectangle2D.Double(width-borderThickness-1, borderThickness, 1, height-(borderThickness*2)));

            //draw sliders an custom position       
            g2d.drawImage(scale(secondSliderImage), null, secondSlider.x, secondSlider.y);
            g2d.drawImage(scale(firstSliderImage), null, firstSlider.x, firstSlider.y);
        }
    }

    @Override
    public Insets getBorderInsets(Component c)
    {
        return (getBorderInsets(c, new Insets(borderThickness, borderThickness, borderThickness, borderThickness)));
    }

    @Override
    public Insets getBorderInsets(Component c, Insets insets)
    {
        insets.left = insets.top = insets.right = insets.bottom = borderThickness;
        return insets;
    }

    @Override
    public boolean isBorderOpaque()
    {
        return false;
    }
}