import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import javax.swing.*;

@SuppressWarnings("serial")
public class LineDraw extends JPanel {
    private static final int PREF_W = 450;
    private static final int PREF_H = 300;
    private BufferedImage img;
    private int yDistance = 20;
    private int deltaY = 10;

    public LineDraw() {
        img = new BufferedImage(PREF_W, PREF_H, BufferedImage.TYPE_INT_ARGB);
        add(new JButton(new DrawLineAction("Draw Line", KeyEvent.VK_D)));
    }

    @Override
    public Dimension getPreferredSize() {
        if (isPreferredSizeSet()) {
            return super.getPreferredSize();
        }
        return new Dimension(PREF_W, PREF_H);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // draw the buffered image here
        if (img != null) {
            g.drawImage(img, 0, 0, this);
        }

        // use rendering hints to draw smooth lines
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // do drawing here
        g.drawLine(10, 10, 20, 300);
    }

    public void drawNewLines() {
        Graphics2D g2 = img.createGraphics();
        g2.setColor(Color.BLACK);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        yDistance += deltaY;
        g2.drawLine(10, 10, yDistance, PREF_H);

        g2.dispose();
        repaint();
    }

    private class DrawLineAction extends AbstractAction {
        public DrawLineAction(String name, int mnemonic) {
            super(name); // give button its text
            putValue(MNEMONIC_KEY, mnemonic); // alt-hot key for button
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            drawNewLines();
        }
    }

    private static void createAndShowGui() {
        LineDraw mainPanel = new LineDraw();

        JFrame frame = new JFrame("Line Draw");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            createAndShowGui();
        });
    }
}