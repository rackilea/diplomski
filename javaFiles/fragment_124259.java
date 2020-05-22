import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JComponent;

public class Circle extends JComponent {
    private static final long serialVersionUID = 628299863960706428L;
    private int xCoo;
    private int yCoo;
    private int diameter;
    private Color color;

    @Override
    public Dimension getPreferredSize() {

        return new Dimension(diameter + xCoo, diameter + yCoo);

    }

    /*  @Override
    public Dimension getMinimumSize() {

        return new Dimension(diameter + xCoo, diameter + yCoo);

    }

    @Override
    public Dimension getMaximumSize() {

        return new Dimension(diameter + xCoo, diameter + yCoo);

    }*/

    public int getXCoo() {
        return xCoo;
    }

    public void setXCoo(final int xCoo) {
        this.xCoo = xCoo;
    }

    public int getYCoo() {
        return yCoo;
    }

    public void setYCoo(final int yCoo) {

        this.yCoo = yCoo;
    }

    public int getDiameter() {
        return diameter;
    }

    public void setDiameter(final int diameter) {
        this.diameter = diameter;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(final Color color) {
        this.color = color;
    }

    public void paintComponent(final Graphics g) {
        super.paintComponent(g);
        g.setColor(color);
        g.fillOval((xCoo - diameter / 2), (yCoo - diameter / 2), diameter, diameter);
    }
}