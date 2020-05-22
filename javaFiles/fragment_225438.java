import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class Server extends JFrame{

    private DrawPoint drawPoint;

    public Server()  {

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        drawPoint = new DrawPoint();
        add(drawPoint);
        pack();
        setVisible(true);
    }

    //This conversion is not essential for the question asked. remove to make it Mcve
    //public String GPStoCoord(  double lat,   double lon){}

    private void GPSlocdraw() {
        //generate random x,y within an arbitrary range
         Random rnd = new Random();    int maxY = 350, maxX = 250;
         Timer timer = new Timer(1000, e -> { //periodically change coordinates and repaint
            drawPoint.setCoordx(rnd.nextInt(maxX));
            drawPoint.setCoordy(rnd.nextInt(maxY));
            drawPoint.repaint();
        });
        timer.start();
    }

    public static void main(     String args[] ) {
        SwingUtilities.invokeLater(() ->    new Server().GPSlocdraw());
    }
}

class DrawPoint extends JPanel {

    private int coordx, coordy, width, height;
    private Image map;

    public DrawPoint() {
        try {
            //to make an mcVe always use publicly available resources
            map = ImageIO.read(new URL("http://www.digitalphotoartistry.com/rose1.jpg"));
            height = map.getHeight(this);
            width = map.getWidth(this);
            setPreferredSize(new Dimension(width, height)); //fit panel to image
        } catch ( IOException ex) {ex.printStackTrace();    }
    }

    @Override
    public void paintComponent(Graphics g){
        //read from file once, not every method run BufferedImage map = ImageIO.read(new File("CSmap.png"));
        super.paintComponent(g);
        g.setColor(Color.YELLOW);
        g.drawImage(map,0,0,this);//image first 
        g.fillOval(coordx,coordy,8,8); //point on top 
    }

    //use setters to change the state
    void setCoordy( int coordy) {this.coordy = coordy;}
    void setCoordx( int coordx) {this.coordx = coordx;}
}