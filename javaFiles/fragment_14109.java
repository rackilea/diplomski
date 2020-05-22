package messaround;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Game {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI(); 
            }
        });
    }

    private static void createAndShowGUI() {
        System.out.println("Created GUI on EDT? "+
        SwingUtilities.isEventDispatchThread());
        JFrame f = new JFrame("Swing Paint Demo");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        f.add(new MyPanel());
        f.pack();
        f.setVisible(true);
    } 
}

class MyPanel extends JPanel {
    BufferedImage boat;
    Timer timer;

    private int boatX = 0;
    private int boatY = 0;
    private int boatW;
    private int boatH;

    public MyPanel() {
        try {
            boat = ImageIO.read(new File("res/ship2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        boatW=boat.getWidth();
        boatH=boat.getHeight();

        timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                moveBoat();
                if(boatX>100){
                    timer.cancel();
                    timer.purge();
                }
            }} ,0, 30);

        setBorder(BorderFactory.createLineBorder(Color.black));

    }

    public void moveBoat(){
        repaint(boatX,boatY,boatW,boatH);
        boatX++;
        boatY++;
        repaint(boatX,boatY,boatW,boatH);
    }


    public Dimension getPreferredSize() {
        return new Dimension(250,200);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(boat, boatX, boatY, this);
    }  
}