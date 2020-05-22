import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author shane
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                try {
                    BufferedImage img = ImageIO.read(new File("C:\\hold\\thumbnails\\_MTCGAC__Pulling_Cords_by_Dispozition.png"));
                    JLabel label = new JLabel(new ImageIcon(img));

                    JFrame frame = new JFrame("Testing");
                    frame.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowOpened(WindowEvent e) {
                            Timer timer = new Timer(10, new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    frame.remove(label);
                                    frame.revalidate();
                                    frame.repaint();
                                }
                            });
                            timer.setRepeats(false);
                            timer.start();
                        }
                    });
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.add(label);
                    frame.pack();
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                } catch (IOException exp) {
                    exp.printStackTrace();
                }
            }
        });
    }

}