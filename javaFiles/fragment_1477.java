package aircraftPackage;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class RotateImage extends JFrame implements KeyListener {
    private static final long serialVersionUID = 1L;
    private static Image TestImage;
    private static RotateImage ri;
    private BufferedImage bf;
    private int cordX = 100;
    private int cordY = 100;
    private double currentAngle;

    public RotateImage(Image TestImage) {
     this.TestImage = TestImage;
     MediaTracker mt = new MediaTracker(this);
     mt.addImage(TestImage, 0);
     try {
       mt.waitForID(0);
     }
     catch (Exception e) {
       e.printStackTrace();
     }
        setTitle("Testing....");
        setSize(500, 500);
        imageLoader();
        setVisible(true);
    }
public void rotate() {
     //rotate 5 degrees at a time
     currentAngle+=5.0;
     if (currentAngle >= 360.0) {
       currentAngle = 0;
     }
     repaint();
   }


    public void imageLoader() {
        try {
            String testPath = "test.png";
            TestImage = ImageIO.read(getClass().getResourceAsStream(testPath));

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        addKeyListener(this);
    }

    public void update(Graphics g){
           paint(g);
    }

    public void paint(Graphics g){

        bf = new BufferedImage( this.getWidth(),this.getHeight(), BufferedImage.TYPE_INT_RGB);

    try{
    animation(bf.getGraphics());
    g.drawImage(bf,0,0,null);
    }catch(Exception ex){

    }
}

    public void animation(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D)g;
        AffineTransform origXform = g2d.getTransform();
        AffineTransform newXform = (AffineTransform)(origXform.clone());
        //center of rotation is center of the panel
        int xRot = this.getWidth()/2;
        int yRot = this.getHeight()/2;
        newXform.rotate(Math.toRadians(currentAngle), xRot, yRot);
        g2d.setTransform(newXform);
        //draw image centered in panel
        int x = (getWidth() - TestImage.getWidth(this))/2;
        int y = (getHeight() - TestImage.getHeight(this))/2;
        g2d.drawImage(TestImage, x, y, this);
        g2d.setTransform(origXform);
        g.drawImage(TestImage, cordX, cordY, this);
    }

    public static void main(String[] args) {
         ri = new RotateImage(TestImage);

    }

    public void keyPressed(KeyEvent ke) {

        switch (ke.getKeyCode()) {
        case KeyEvent.VK_RIGHT: {
            cordX += 5;

           ri.rotate();
        }
            break;
        case KeyEvent.VK_LEFT: {
            cordX -= 5;
            ri.rotate();
        }
            break;
        case KeyEvent.VK_DOWN: {
            cordY += 5;
            ri.rotate();
        }
            break;
        case KeyEvent.VK_UP: {
            cordY -= 3;
            ri.rotate();
        }
            break;
        }
        repaint();
    }

    public void keyTyped(KeyEvent ke) {
    }

    public void keyReleased(KeyEvent ke) {
    }
}