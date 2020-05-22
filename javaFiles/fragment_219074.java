import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;

public class PhoneWindow {

    public static void main(String[] args) {
        new PhoneWindow();
    }

    public PhoneWindow() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    final JFrame frame = new JFrame();
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    // create the  inner frame
                    final JInternalFrame frame2 = new JInternalFrame("My Telephone");
                    frame2.setClosable(true);
                    frame2.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
                    // add elements to the outer frame
                    frame.setUndecorated(true);
                    frame.setBackground(new Color(0, 0, 0, 0));
                    JPanel pane = new TranslucentPane();
                    frame.setContentPane(pane);
                    frame.setLayout(new BorderLayout());
                    // add inner frame and phone picture
                    frame.add(frame2, BorderLayout.CENTER);
                    frame.add(new JLabel(new ImageIcon(ImageIO.read(getClass().getResource("/transparent-phone.png")))), BorderLayout.EAST);
                    frame.setLocationRelativeTo(null);
                    frame.setMinimumSize(new Dimension(400, 300));
                    frame.pack();
                    // show
                    frame2.setVisible(true);
                    frame.setVisible(true);
                } catch (Throwable ex) {
                    ex.printStackTrace();
                }

            }
        });
    }

    public class TranslucentPane extends JPanel {

        public TranslucentPane() {
            setOpaque(false);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setComposite(AlphaComposite.SrcOver.derive(0f));
            g2d.setColor(getBackground());
            g2d.fillRect(0, 0, getWidth(), getHeight());
        }

    }

}