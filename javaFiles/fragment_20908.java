public class LoginPanel extends JPanel {
    private BufferedImage background;

    public LoginPanel(BufferedImage background) {
        this.background = background;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (background != null) {
            g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
        }
    }
}