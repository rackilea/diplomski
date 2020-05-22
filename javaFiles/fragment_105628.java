package com.example.test.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Path2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class HoleClipper extends JPanel
{
    @Override protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        Rectangle2D r1 = getBounds();
        int margin = 50;
        Rectangle2D r2 = new Rectangle2D.Double(
                r1.getMinX()+margin,
                r1.getMinY()+margin,
                r1.getWidth()-2*margin,
                r1.getHeight()-2*margin);

        g2d.setColor(Color.YELLOW);
        g2d.fill(r1);

        Path2D p = new Path2D.Double(Path2D.WIND_EVEN_ODD);
        p.append(r1, false);
        p.append(r2, false);
        g2d.clip(p);

        int spacing = 10;
        g2d.setColor(Color.BLACK);
        for (double d = 0; d < r1.getWidth() + r1.getHeight(); d += spacing)
        {
            Line2D line = new Line2D.Double(0, d, d, 0);
            g2d.draw(line);
        }
    }

    public static void main(String[] args) {
        HoleClipper clipper = new HoleClipper();
        clipper.setPreferredSize(new Dimension(300, 200));

        JFrame frame = new JFrame("HoleClipper");
        frame.setContentPane(clipper);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}