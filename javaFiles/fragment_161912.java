import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.*;

public class GridTest {

    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;

    private static void createAndShowGui() {

        Grid mainPanel = new Grid(WIDTH, HEIGHT);

        JFrame frame = new JFrame("Grid Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}