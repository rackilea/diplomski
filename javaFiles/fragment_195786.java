import java.awt.Desktop;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class Test {

    JFrame f;
    JLabel c;
    BufferedImage image;
    int x = -1, y = -1;

    public Test() {
        f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        image = new BufferedImage(1200, 800, BufferedImage.TYPE_INT_ARGB);
        c = new JLabel(new ImageIcon(image));

        f.add(c);
        c.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseMoved(MouseEvent e) {
                // empty
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                if (x == -1) {
                    x = e.getX();
                    y = e.getY();
                }
                image.getGraphics().fillOval(x, y, 5, 5);
                c.repaint();
                x = e.getX();
                y = e.getY();
            }
        });
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent evt) {
                onExit();
            }

            public void onExit() {
                try {
                    File output = new File("C:\\test\\canvas.png");
                    if (!output.getParentFile().exists()) {
                        output.getParentFile().mkdirs();
                    }
                    ImageIO.write(image, "png", output);
                    Desktop.getDesktop().open(output);
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
        f.pack();
        f.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                Test paintBrush = new Test();
            }
        });
    }

}