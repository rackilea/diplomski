import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class QuiltPattern {
    private int height, width, x, y;
    private Color color;

    public QuiltPattern(int size, Color newColor) {
        width = size;
        height = size;
        color = newColor;
    }

    public void draw(Graphics page, int x, int y) {
        page.setColor(color);
        page.fillRect(x, y, width, height);
    }

    public void setHeight(int size) {
        height = size;
    }

    public void setWidth(int size) {
        width = size;
    }

    public void setColor(Color newColor) {
        color = newColor;
    }

    public void setX(int upperX) {
        x = upperX;
    }

    public void setY(int upperY) {
        y = upperY;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public Color getColor() {
        return color;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}