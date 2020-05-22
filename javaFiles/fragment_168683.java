package weekThree;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.*;

@SuppressWarnings("serial")
public class Die extends JPanel {


    static Random rand = new Random();
    // make roll a field to be seen by all methods
    private int roll;
    private Color circleColor = Color.BLACK;
    private int circX  = 75;
    private int circY = circX;
    private int circW = 75;
    private int circH = circW;

    public Die() {
        addMouseListener(new MyMouse());
    }

    protected void paintComponent(Graphics g) {

        super.paintComponent(g);
        // remove the randomize logic from here
        //int roll = (rand.nextInt(6) + 1); //rolls the dice

        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); //smoothes edges
        g2.setColor(circleColor);

        if (roll == 1) {  //each body updates the associated dots
            g2.fillOval(325, 325, circW, circH);
            g2.drawOval(325, 325, circW, circH);
        }

        if (roll == 2) {
            g2.fillOval(circX, circY, circW, circH);
            g2.drawOval(circX, circY, circW, circH);

            g2.fillOval(600, 600, circW, circH);
            g2.drawOval(600, 600, circW, circH);
        }

        if (roll == 3) {
            g2.fillOval(circX, 600, circW, circH);
            g2.drawOval(circX, 600, circW, circH);

            g2.fillOval(325, 325, circW, circH);
            g2.drawOval(325, 325, circW, circH);

            g2.fillOval(600, circY, circW, circH);
            g2.drawOval(600, circY, circW, circH);
        }

        if (roll == 4) {
            g2.fillOval(circX, circY, circW, circH);
            g2.drawOval(circX, circY, circW, circH);

            g2.fillOval(600, circY, circW, circH);
            g2.drawOval(600, circY, circW, circH);

            g2.fillOval(circX, 600, circW, circH);
            g2.drawOval(circX, 600, circW, circH);

            g2.fillOval(600, 600, circW, circH);
            g2.drawOval(600, 600, circW, circH);
        }

        if (roll == 5) {
             g2.fillOval(circX, circY, circW, circH);
             g2.drawOval(circX, circY, circW, circH);

             g2.fillOval(600, circY, circW, circH);
             g2.drawOval(600, circY, circW, circH);

             g2.fillOval(600, 600, circW, circH);
             g2.drawOval(600, 600, circW, circH);

             g2.fillOval(circX, 600, circW, circH);
             g2.drawOval(circX, 600, circW, circH);

             g2.fillOval(325, 325, circW, circH);
             g2.drawOval(325, 325, circW, circH);
        }

        if (roll == 6) {
            g2.fillOval(circX, circY, circW, circH);
            g2.drawOval(circX, circY, circW, circH);

            g2.fillOval(600, circY, circW, circH);
            g2.drawOval(600, circY, circW, circH);

            g2.fillOval(600, 325, circW, circH);
            g2.drawOval(600, 325, circW, circH);

            g2.fillOval(600, 600, circW, circH);
            g2.drawOval(600, 600, circW, circH);

            g2.fillOval(circX, 325, circW, circH);
            g2.drawOval(circX, 325, circW, circH);

            g2.fillOval(circX, 600, circW, circH);
            g2.drawOval(circX, 600, circW, circH);
        }

    }

    public void updateVal(int i) {  //takes an int i between 1 and 6 and updates the face

        if (i < 1 || i > 6) {
            new IndexOutOfBoundsException("Choose a number between 1 and 6!");
        }

        else {
            //here the face of the die should be updated according to what value of i is passed through
            // static assinment and 'make the graphic'
            roll = i;
            repaint();
        }
    }

    private class MyMouse extends MouseAdapter {

        Random rand = new Random();

        public void mousePressed(MouseEvent e) {
            //
            // updateVal(2); // can be used for test
            // randomize and 'make the graphic'
            roll = rand.nextInt(6);  //re-roll dice on click
            repaint();  //repaint components accordingly
        }
    }

    private static void createAndShowGui() { //creation of GUI visuals
        JFrame frame = new JFrame("Die Roller");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new Die());

        frame.setSize(800, 800);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGui();
            }
        });
    }
}