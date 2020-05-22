import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.logging.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.Timer;

class MyCanvas extends JPanel implements ActionListener
{
  public BufferedImage buffImg;
  public Rectangle rectangle;
  Random random;
  long lastTimeChanged;
  int dirX = 1, dirY = 1;
  volatile static boolean imageLoading = true; 
    public MyCanvas() {
        random = new Random();
        rectangle = new Rectangle(50, 50, 250, 250);
        lastTimeChanged = System.currentTimeMillis();
        setBackground(Color.WHITE);
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); 

        if(imageLoading)
        {
            showWaitForLoading(g);
            return;
        }

        g.clipRect(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
        g.drawImage(buffImg, 0, 0, getWidth(), getHeight(), this);

    }


    public void showWaitForLoading(Graphics g)
    {
        Graphics2D g2d = (Graphics2D)g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(Color.DARK_GRAY);
        g2d.fillRoundRect(getWidth()/2-100, getHeight()/2-15, 200, 30, 30, 30);
        g2d.setColor(Color.WHITE);
        g2d.drawString("Loading image...", getWidth()/2 - 45, getHeight()/2 + 3 );
        g2d.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        long endTime = System.currentTimeMillis();
        if(endTime - lastTimeChanged > 500)
        {
            dirX = random.nextInt(2) == 0 ? -1 : 1;
            dirY = random.nextInt(2) == 0 ? -1 : 1;
            lastTimeChanged = endTime;
        }

        if(rectangle.x < 0)dirX = 1;
        else if(rectangle.x + rectangle.width > getWidth())dirX = -1;

        if(rectangle.y < 0)dirY = 1;
        else if(rectangle.y + rectangle.height > getHeight())dirY = -1;

        rectangle.x = rectangle.x + dirX * 10;
        rectangle.y = rectangle.y + dirY * 10;;

        repaint();
    }

}
public class CustomPainting {


    public static void main(String[] args) throws IOException {

        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
               final MyCanvas canvas = new MyCanvas();
               JFrame frame = new JFrame();
              frame.setSize(new Dimension(500, 500));
              frame.add(canvas);
              frame.setVisible(true);
              frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

              Timer timer = new Timer(200, canvas);
              timer.start();
              new Thread()
              {
                  public void run()
                  {
                      try {
                          canvas.buffImg = ImageIO.read(new URL("http://images6.fanpop.com/image/photos/33400000/Cute-Panda-beautiful-pictures-33434826-500-500.jpg"));
                          MyCanvas.imageLoading = false;
                      } catch (IOException ex) {
                          Logger.getLogger(CustomPainting.class.getName()).log(Level.SEVERE, null, ex);
                      }
                  }
              }.start();
            }
        });
    }
}