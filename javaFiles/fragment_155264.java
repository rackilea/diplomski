import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.Timer;


public class ImageRotationFrame {

    public static void main(String[] args) {
        new ImageRotationFrame();
    }

    public ImageRotationFrame() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("Testing");
                frame.setSize(400, 400);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new ImageRotationComponent());
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });

    }

    private class ImageRotationComponent extends JComponent {

        Image arrow;
        double angle = 0.0;

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            angle += 0.4;
            AffineTransform trans = AffineTransform.getRotateInstance(angle, getWidth() / 2, getHeight() / 2);
            ((Graphics2D) g).drawImage(arrow, trans, this);
        }

        public ImageRotationComponent() {
            try {
                arrow = ImageIO.read(new File("dice.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            int delay = 500; //milliseconds
            ActionListener taskPerformer = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    ImageRotationComponent.this.repaint();
                }
            };
            new Timer(delay, taskPerformer).start();
        }
    }
}