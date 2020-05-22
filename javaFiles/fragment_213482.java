JXPanel panel = new JXPanel() {
    int shadowSize = 40;
    ShadowRenderer renderer = new ShadowRenderer(shadowSize/ 2, 0.5f, Color.RED); 
    BufferedImage imageA = 
            XTestUtils.loadDefaultImage("moon.jpg");
    BufferedImage shadow;

    @Override
    public void setBounds(int x, int y, int width, int height) {
        super.setBounds(x, y, width, height);
        // not really needed here - the base image size is fixed
        shadow = renderer.createShadow(imageA); 
    }

    @Override
    protected void paintComponent(Graphics g) {
        int x = (getWidth() - imageA.getWidth()) / 2;
        int y = (getHeight() - imageA.getHeight()) / 2;

        Graphics2D g2 = (Graphics2D) g;
        Composite c = g2.getComposite();
        g2.setComposite(AlphaComposite.SrcOver.derive(renderer.getOpacity()));
        g.drawImage(shadow, x - shadowSize / 2, y - shadowSize / 2, null);
        g2.setComposite(c);
        g.drawImage(imageA, x, y, null);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(imageA.getWidth() + shadowSize, imageA.getHeight()+ shadowSize);
    }

};
panel.setOpaque(false);