import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

@SuppressWarnings("serial")
public class BorderTest extends JPanel {
    private JPanel testPanel = new JPanel();

    public BorderTest() {
        testPanel.setPreferredSize(new Dimension(400, 300));
        testPanel.setBorder(new BorderEffect2(testPanel, Color.BLUE));
        testPanel.setBackground(Color.WHITE);

        setPreferredSize(new Dimension(500, 400));
        setLayout(new GridBagLayout());
        add(testPanel);
    }

    private static void createAndShowGui() {
        BorderTest mainPanel = new BorderTest();

        JFrame frame = new JFrame("BorderTest");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}