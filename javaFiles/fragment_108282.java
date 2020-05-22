package com.epox.cmc.core.util;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import javax.swing.Icon;

public class ColorIcon implements Icon {
    String iconColor ;
    ColorIcon(String iconColor) {
        this.iconColor = iconColor;
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        g.setColor(Color.decode(iconColor)); //<-- This is the problem
        g.drawRect(7, 5, 11, 11);
        g.fillRect(7, 5, 11, 11);
    }

    @Override
    public int getIconWidth() {
        return 16;
    }

    @Override
    public int getIconHeight() {
        return 16;
    }
}