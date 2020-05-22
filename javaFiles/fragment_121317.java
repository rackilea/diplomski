import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

@SuppressWarnings("serial")
public class DrawingPanel extends JPanel {
    private static final int PREF_W = 600;
    private static final int PREF_H = PREF_W;
    private static final int TIMER_DELAY = 20;
    private static final Color[] SQUARE_COLOR = { Color.BLUE, Color.CYAN, Color.DARK_GRAY,
            Color.BLACK, Color.GRAY, Color.GREEN, Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE,
            Color.PINK, Color.RED, Color.YELLOW };
    List<Square> squareList = new ArrayList<>();

    public DrawingPanel() {
        // create a bunch of squares
        for (int i = 0; i < SQUARE_COLOR.length; i++) {
            squareList.add(new Square(SQUARE_COLOR[i], PREF_W, PREF_H));
        }

        setBackground(Color.WHITE);

        // create and start the timer
        new Timer(TIMER_DELAY, new TimerListener()).start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // simply draw all the squares in the list
        for (Square square : squareList) {
            square.draw(g);
        }
    }

    // set size of JPanel
    @Override
    public Dimension getPreferredSize() {
        if (isPreferredSizeSet()) {
            return super.getPreferredSize();
        }
        return new Dimension(PREF_W, PREF_H);
    }

    private class TimerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {            
            // simply iterate through list and move all squares
            for (Square square : squareList) {
                square.move();
            }
            repaint(); // then repaint the GUI
        }
    }

    private static void createAndShowGui() {
        DrawingPanel mainPanel = new DrawingPanel();

        JFrame frame = new JFrame("Drawing Panel");
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

// this class does *not* extend JPanel or JComponent
class Square {
    public static final int WIDTH = 20;

    // location of Square
    private double sqrX;
    private double sqrY;

    // X and Y speed
    private double deltaX;
    private double deltaY;

    // width and height of DrawingPanel JPanel
    private int dpWidth;
    private int dpHeight;

    // image to draw
    private Image image;

    public Square(Color color, int dpWidth, int dpHeight) {
        this.dpWidth = dpWidth;
        this.dpHeight = dpHeight;

        // create square at random location with random speed
        sqrX = Math.random() * (dpWidth - WIDTH);
        sqrY = Math.random() * (dpHeight - WIDTH);
        deltaX = Math.random() * 10 - 5;
        deltaY = Math.random() * 10 - 5;

        // one way to draw it is to create an image and draw it
        image = new BufferedImage(WIDTH, WIDTH, BufferedImage.TYPE_INT_ARGB);
        Graphics g = image.getGraphics();
        g.setColor(color);
        g.fillRect(0, 0, WIDTH, WIDTH);
        g.dispose();
    }

    public void move() {

        // check that we're not hitting boundaries
        if (sqrX + deltaX < 0) {
            deltaX = Math.abs(deltaX);
        }
        if (sqrX + deltaX + WIDTH >= dpWidth) {
            deltaX = -Math.abs(deltaX);
        }
        sqrX += deltaX;

        // check that we're not hitting boundaries
        if (sqrY + deltaY < 0) {
            deltaY = Math.abs(deltaY);
        }
        if (sqrY + deltaY + WIDTH >= dpHeight) {
            deltaY = -Math.abs(deltaY);
        }
        sqrY += deltaY;

    }

    public void draw(Graphics g) {
        int x = (int) sqrX;
        int y = (int) sqrY;
        g.drawImage(image, x, y, null);
    }
}