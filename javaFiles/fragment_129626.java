import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;
import java.util.Random;

class ImageBlinker extends JComponent {

    BufferedImage image;
    boolean showImage;
    int x = -1;
    int y = -1;
    Random r;

    ImageBlinker() {
        // put your image reading code here..
        image = new BufferedImage(32,32,BufferedImage.TYPE_INT_ARGB);
        Graphics g = image.createGraphics();
        g.setColor(Color.ORANGE);
        g.fillOval(0,0,32,32);
        // END - image read

        r = new Random();
        ActionListener listener = new ActionListener(){
            public void actionPerformed(ActionEvent ae) {
                if (image!=null) {
                    if (!showImage) {
                        int w = image.getWidth();
                        int h = image.getHeight();
                        int rx = getWidth()-w;
                        int ry = getHeight()-h;
                        if (rx>-1 && ry>-1) {
                            x = r.nextInt(rx);
                            y = r.nextInt(ry);
                        }
                    }
                    showImage = !showImage;
                    repaint();
                }
            }
        };
        Timer timer = new Timer(600,listener);
        timer.start();

        setPreferredSize(new Dimension(150,100));
        JOptionPane.showMessageDialog(null, this);
        timer.stop();
    }

    public void paintComponent(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(0,0,getWidth(),getHeight());
        if (showImage && image!=null) {
            g.drawImage(image,x,y,this);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ImageBlinker();
            }
        });
    }
}