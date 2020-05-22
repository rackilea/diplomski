package com.example.game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.Random;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

    public class Game extends JPanel {      
        public static void main(String[] args) {
            javax.swing.SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    start();
                }
            });
        }

        static void start() {
            final JFrame frame = new JFrame("Game");
            JPanel newFrame = new MainGameScreen();

            frame.addComponentListener(new ComponentAdapter() {
                @Override
                public void componentResized(ComponentEvent e) {
                    int h = frame.getContentPane().getHeight() % MainGameScreen.ROWS;
                    int w = frame.getContentPane().getWidth() % MainGameScreen.COLS;

                    // Subtract the remainder pixels from the size.
                    frame.setSize(frame.getWidth() - w, frame.getHeight() - h);
                }
            });
            frame.getContentPane().add(newFrame);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        }
    }
    class MainGameScreen extends JPanel {
        static final int ROWS = 13;
        static final int COLS = 27;

        public MainGameScreen() {
            setPreferredSize(new Dimension(864, 551));
            setLayout(new GridBagLayout());
            setBackground(Color.green);
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.fill = GridBagConstraints.BOTH;
            gbc.weightx = 1;
            gbc.weighty = 1;
            gbc.ipadx = 0; //Change to 64 to see undesired effects
            gbc.ipady = 0; //^
            for (int i=0;i<ROWS;i++) {
                for (int j=0;j<COLS;j++) {
                    gbc.gridx = j;
                    gbc.gridy = i;
                    add(new ImagePanel(), gbc);
                }
            }
        }
    }

    class ImagePanel extends JComponent { 
        private int r,g,b;
        public ImagePanel() {
            Random generator = new Random();
            r = generator.nextInt(100)+1;
            g = generator.nextInt(100)+1;
            b = generator.nextInt(100)+1;
        }
        @Override
        public void paintComponent(Graphics gr) {
            super.paintComponent(gr);
            gr.setColor(new Color(r,g,b));
            gr.fillRect(0, 0, getWidth(), getHeight());
        }
}