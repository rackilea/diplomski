package com.ggl.testing;

import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class DisplayImage {

    public DisplayImage() {
        displayImage(getImage());
    }

    private Image getImage() {
        try {
            return ImageIO.read(getClass().getResourceAsStream(
                    "StockMarket.png"));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void displayImage(Image image) {
        JLabel label = new JLabel(new ImageIcon(image));

        JPanel panel = new JPanel();
        panel.add(label);

        JScrollPane scrollPane = new JScrollPane(panel);
        JOptionPane.showMessageDialog(null, scrollPane);
    }

    public static void main(String[] args) {
        new DisplayImage();
    }

}