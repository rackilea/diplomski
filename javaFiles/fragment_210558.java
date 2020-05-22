public class RenderZone extends JPanel {

    private static final long serialVersionUID = -8240875812801921009L;

    private BufferedImage image = null;
    private BufferedImage sub = null;

    public RenderZone() {
        this.setBackground(Color.WHITE);
        this.setPreferredSize(new Dimension(1124, 768));// added 100 for test purpose
        image = new BufferedImage(2000, 1000, BufferedImage.TYPE_INT_RGB);
        sub = image.getSubimage(0, 0, 1024, 768);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);// pour repeindre la panel à chaque fois
        if (sub != null) {
            g.drawImage(sub, 0, 0, this);
        }
    }
}