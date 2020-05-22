import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class GleisMain {
    private static void createAndShowGui() {
        GleisPainter gleisPainter = new GleisPainter();

        gleisPainter.addGleis(new Gleis(10, 10, 0, 0));
        gleisPainter.addGleis(new Gleis(20, 20, 1, 1));
        gleisPainter.addGleis(new Gleis(30, 30, 2, 2));

        // I try to avoid having classes extend JFrame and instead use JFrames when needed
        JFrame frame = new JFrame("Gleis Example");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(gleisPainter);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
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

// a single class that extend JPanel and that draws all the Gleis objects
class GleisPainter extends JPanel {
    // an ArrayList to hold all the Gleis objects
    private List<Gleis> gleisList = new ArrayList<>();

    // to allow outside classes to add Gleis objects
    public void addGleis(Gleis gleis) {
        gleisList.add(gleis);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // loop through our gleis list and draw each instance
        Graphics2D g2 = (Graphics2D) g;
        for (Gleis gleis : gleisList) {
            gleis.draw(g2);  // by calling its draw(...) method
        }
    }
}

// don't have this extend JPanel
class Gleis {
    // fields should be private
    private int xposition;
    private int yposition;
    private int id;
    private int status;

    public Gleis(int xpos, int ypos, int id, int status) {    
        this.xposition = xpos * 11;
        this.yposition = ypos * 11 + 4;
        this.id = id;
        this.status = status;

        System.out.println(this.id);
    }

    // give this a public draw method where each instance can draw itself
    public void draw(Graphics2D g2) {
        g2.setColor(Color.black);

        // you'll want to avoid "magic" numbers like you're using here:
        g2.fillRect(this.xposition, this.yposition, 11, 4);

        if (this.status == 0)
            g2.setColor(Color.gray);
        else if (this.status == 1)
            g2.setColor(Color.red);
        else if (this.status == 2)
            g2.setColor(Color.yellow);
        else
            g2.setColor(Color.gray);

        // ditto about use of "magic" numbers
        g2.fillRect(this.xposition + 2, this.yposition + 1, 7, 2);
    }    
}