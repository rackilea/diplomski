package com.ggl.drawing;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

public class DrawPanel extends JPanel {

    private static final long serialVersionUID = 3443814601865936618L;

    private GUIModel model;

    public DrawPanel(int width, int height, GUIModel model) {
        this.setPreferredSize(new Dimension(width, height));
        this.model = model;
        // add mouse listeners
        MouseHandler mouseHandler = new MouseHandler();
        this.addMouseListener(mouseHandler);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (model.getCoordinate() != null) {
            Point p = model.getCoordinate();
            Font font = g.getFont().deriveFont(48F);
            g.setFont(font);
            g.drawString(model.getDisplayString(), p.x, p.y);
        }
    }

    // class to handle all mouse events
    private class MouseHandler extends MouseAdapter {

        @Override
        public void mousePressed(MouseEvent event) {
            model.setCoordinate(event.getPoint());
        }

        @Override
        public void mouseReleased(MouseEvent event) {
            DrawPanel.this.repaint();
        }

    }
}