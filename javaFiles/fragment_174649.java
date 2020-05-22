import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

public class Tile {
    final private static int CELL_WIDTH = 50;
    final private static int CELL_HEIGHT = 50;

    final private static int BOARD_X_OFFSET = 25;
    final private static int BOARD_Y_OFFSET = 25;

    private int x;
    private int y;
    private String label;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Tile() {
        this(0, 0, "?");
    }

    public Tile(int x, int y, String label) {
        this.x = getScreenX(x);
        this.y = getScreenY(y);
        this.label = label;
    }

    private int getScreenX(int x) {
        return BOARD_X_OFFSET + (x * CELL_WIDTH);
    }

    private int getScreenY(int y) {
        return BOARD_Y_OFFSET + (y * CELL_HEIGHT);
    }

    public void paintComponent(Graphics g) {
        Font font = new Font("Arial", Font.BOLD, 16);
        FontMetrics metrics = g.getFontMetrics(font);
        int fontWidth = metrics.stringWidth(label);
        int fontHeight = metrics.getHeight();

        int xPos = x + BOARD_X_OFFSET - (fontWidth / 2);
        int yPos = y + BOARD_Y_OFFSET + (fontHeight / 2);

        g.setFont(font);
        g.setColor(Color.BLACK);
        g.drawRect(x, y, CELL_WIDTH, CELL_HEIGHT);
        g.drawString(label, xPos, yPos);
    }
}