package com.sandbox;

import javax.swing.*;
import java.awt.*;

public class SwingSandbox {

    public static void main(String[] args) {

        JFrame frame = buildFrame();
        JPanel cards = new JPanel(new CardLayout());

        cards.add(new JPanelThatPrints("1"));
        cards.add(new JPanelThatPrints("2"));
        cards.add(new JPanelThatPrints("3"));

        frame.add(cards);
    }


    private static JFrame buildFrame() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(200, 200);
        frame.setVisible(true);
        return frame;
    }


    private static class JPanelThatPrints extends JPanel {

        private String message;

        public JPanelThatPrints(String message) {
            this.message = message;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            System.out.println(message);
        }
    }
}