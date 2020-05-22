public class RendPanel extends JPanel {

    private static final long serialVersionUID = 1L;

    int widthe  = 320;
    int heighte = 240;

    int ang = 0;
    double x0 = 0.5 * (widthe  - 1);     // point to rotate about
    double y0 = 0.5 * (heighte - 1);     // center of image

    public static BufferedImage fbuffer;
    public RendPanel(int width, int height) {
        fbuffer = new BufferedImage(320, 240, BufferedImage.TYPE_INT_RGB);

        BufferedImage in = null;
        try { in = ImageIO.read(new File("square.png")); } //32x32 square .png
        catch (IOException e) { e.printStackTrace(); }

        for (int i = 0; i < in.getWidth(); i++) {
            for (int j = 0; j < in.getHeight(); j++) {
                fbuffer.setRGB(i + (320 / 2) - 16, j + (240 / 2) - 16, in.getRGB(i, j));
            }
        }

        setPreferredSize(new Dimension(width, height));
    }

    BufferedImage neww;
    public void r(){
        neww = new BufferedImage(320, 240, BufferedImage.TYPE_INT_RGB);

        double angle = Math.toRadians(ang);
        double sin = Math.sin(angle);
        double cos = Math.cos(angle);

        for (int x = 0; x < widthe; x++) {
            for (int y = 0; y < heighte; y++) {
                if(x >= x0 - 32 && x <= x0 + 32 && y >= y0 - 32 && y <= y0 + 32){
                    double a = x - x0;
                    double b = y - y0;
                    int xx = (int) (+a * cos - b * sin + x0);
                    int yy = (int) (+a * sin + b * cos + y0);

                    // plot pixel (x, y) the same color as (xx, yy) if it's in bounds
                    if (xx >= 0 && xx < widthe && yy >= 0 && yy < heighte) {
                        neww.setRGB(x, y, fbuffer.getRGB(xx, yy));
                    }
                }
            }
        }

        ang++;
        repaint();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(neww, 0, 0, null);
    }
}