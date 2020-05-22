public class PaintPanel extends JPanel {

    private static final long serialVersionUID = 1L;

    BufferedImage icon;

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(getBufferedIcon(), 12, 12, null);
    }

    public void setBufferedIcon(BufferedImage icon) {
        this.icon = icon;
    }

    private BufferedImage getBufferedIcon() {
        return icon;
    }
}