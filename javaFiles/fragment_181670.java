//always post an MCVE
//see http://stackoverflow.com/help/mcve
//include imports 
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author JesperJørgensen
 */
public class GraphicsFrame extends JFrame {/*JFrame  subclassing is never used*/

    //This JPanel is never used
    private JPanel man = new JPanel();
    Image image;

    void setupframe() {
        // Here we create the Frame
        JFrame frame = new JFrame(); // create the frame
        frame.setSize(500,500);
        frame.setLayout(new BorderLayout());
        frame.setResizable(false);

        frame.setTitle("Zuul the ultimate fridaybar game"); // sets title in top bar of frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // what will happens when the frame close (exit)

        //initialize image
        image = new ImageIcon("src/Image/Kort.png").getImage();
        //frame.add(new JLabel(image));

        frame.setContentPane(new DrawPane());

        //if you don't use preferred sizes pack() will set frame to size 0.
        //frame.pack(); // sets the size of the frame to fit all objects    inside.
        frame.setVisible(true); // show the frame

    }

    class DrawPane extends JPanel {

        @Override
        protected void paintComponent(Graphics g) {

            //add draw image to paint
            g.drawImage(image,0, 0, null);

            //this draws a rectangle. change to circle if desired
            g.setColor(Color.red);
            g.fillRect(20, 20, 100, 200);

        }
    }

    //include main to make it an MCVE
    public static void main(String args[]) {

        new GraphicsFrame().setupframe();
    }
}