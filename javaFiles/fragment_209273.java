public class BlueSpell {
    BufferedImage bi;
    int x, y;
    int width = someWidth;
    int height = someHeight;
    JPanel panel;

    public BlueSpell(BufferedImage bi, int x, int y, panel) {
        this.bi = bi;
        this.x = x;
        this.y = y;
        this.panel = panel;
    }

    public void drawSpell(Graphics g) {
        g.drawImage(bi, x, y, width, height, panel);
    }

    public void animate() {
        x += 5;
    }
}