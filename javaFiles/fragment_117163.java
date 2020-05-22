public static void main(String[] args) {
    JFrame frame = new JFrame();
    final int r = 100;
    final int p = 10;

    NewJPanel pan = new NewJPanel(r, p, new A() {
        @Override
        public void doImage(BufferedImage i) {
            int o = 0;

            for (int j = 0; j < i.getWidth() - p; j++) {
                for (int k = 0; k < i.getHeight() - p; k++) {

                    PixelGrabber pix2 = new PixelGrabber(
                            i, j, k, p, p, false);
                    try {
                        pix2.grabPixels();
                    } catch (InterruptedException ex) {}

                    int pixelColor = pix2.getColorModel()
                            .getRGB(pix2.getPixels());

                    Color c = new Color(pixelColor);
                    if (c.equals(Color.WHITE)) {
                        System.out.println("Found at : x:" + j + ",y:" + k);
                    }

                }
            }
        }
    });

    frame.getContentPane().add(pan);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(500, 500);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
}

private interface A {
    void doImage(BufferedImage i);
}

private static class NewJPanel extends JPanel {
    private static final long serialVersionUID = -5348356640373105209L;

    private BufferedImage image = null;
    private int px;
    private int rc;
    private A a;

    public NewJPanel(int r, int p, A a) {
        this.px = p;
        this.rc = r;
        this.a = a;
    }

    public BufferedImage getImage() {
        return image;
    }

    @Override public void paint(Graphics g) {
        super.paint(g);

        image = new BufferedImage(this.rc, this.rc,
                BufferedImage.TYPE_INT_ARGB);
        java.awt.Graphics2D g2 = image.createGraphics();

        g2.setColor(Color.BLACK);
        g2.fillRect(0, 0, this.rc, this.rc);
        g2.setColor(Color.WHITE);
        g2.fillRect(
                new Random().nextInt(this.rc - this.px),
                new Random().nextInt(this.rc - this.px),
                this.px, this.px);

        g.drawImage(image, this.rc, this.rc, this);
        this.a.doImage(this.image);
    }
}