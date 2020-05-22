(MainTest.java)
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainTest extends JFrame { 

ImageEditor img;
JPanel panel;
Timer t;

public MainTest()
{
    setSize(600,600);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    getContentPane().setLayout(null);

    img = new ImageEditor();
    panel = img;
    panel.setBounds(0, 0, 510, 510);
    getContentPane().add(panel);

    JButton btnStart = new JButton("Start");
    btnStart.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            test();
        }
    });
    btnStart.setBounds(0, 528, 89, 23);
    getContentPane().add(btnStart);
}

private void test() {
    Train tx = new Train(img);
    t = new Timer(100, tx);
    t.start();
}

public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable()
    {
        public void run()
        {
            MainTest frame = new MainTest();
            frame.setVisible(true);
        }
    });

  }

}

(ImageEditor.java)
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

@SuppressWarnings("serial")
public class ImageEditor extends JPanel  {

private static BufferedImage img = new BufferedImage(500, 500, 1);  

public ImageEditor() {
    setLayout(null);
}

public void paintComponent(Graphics g) {
    if (img == null)
        super.paintComponents(g);
    else
        g.drawImage(img, 0, 0, this);
}

public void render() {

float cellWidth = 10;
float cellHeight = 10;

    int imgW = img.getWidth();
    int imgH = img.getHeight();
    float r, g, b;
    Graphics2D g2 = img.createGraphics();
    g2.setBackground(Color.black);
    g2.clearRect(0,0,imgW,imgH);
    for (int x=0; x<100; x++) {
        for (int y=0; y<100; y++) {
            r = (float)Math.random();
            g = (float)Math.random();
            b = (float)Math.random();
            g2.setColor(new Color(r,g,b));
            g2.fillRect((int)(x*cellWidth), (int)(y*cellHeight),
                        (int)cellWidth+1, (int)cellHeight+1);
        }
    }
    g2.setColor(Color.black);
    g2.dispose();
    repaint();
}

public BufferedImage getImage() {
    if (img == null)
        img = (BufferedImage)createImage(500, 500);

    return img;
}

public void setImage(BufferedImage bimg) {
    img = bimg;
}

}

(Train.java this class was named ThirdClass.java in my question)
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Train implements ActionListener {

ImageEditor temp;

Train(ImageEditor img)
{
    temp = img;
}

public void train()
{
    temp.render();  
}

@Override
public void actionPerformed(ActionEvent e) {
    train();
}

}