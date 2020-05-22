package com.ggl.layout.view;

import java.awt.Graphics;

import javax.swing.JPanel;

import com.ggl.layout.model.LayoutModel;

public class DrawingPanel extends JPanel {

    private static final long serialVersionUID = 6305888561097318682L;

    private LayoutModel model;

    public DrawingPanel(LayoutModel model) {
        this.model = model;
        this.setPreferredSize(model.getPreferredSize());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

}