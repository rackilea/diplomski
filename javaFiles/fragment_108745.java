import java.awt.*;
import java.awt.event.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.*;
import javax.swing.*;

public class SplashDialogDemo {

    public SplashDialogDemo() {
        JPanel panel = new JPanel() {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(400, 400);
            }
        };
        panel.setBackground(Color.BLACK);

        JFrame frame = new JFrame();
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBackground(Color.BLACK);
        frame.pack();
        frame.setLocationRelativeTo(null);

        SplashDialog splash = new SplashDialog(frame, true);
    }

    public class SplashDialog extends JDialog {

        public SplashDialog(final JFrame parent, boolean modal) {
            super(parent, modal);

            JLabel background = new JLabel(createImage());
            background.setLayout(new BorderLayout());
            setContentPane(background);

            final JPanel panel = new JPanel(new GridBagLayout());
            panel.setVisible(false);
            panel.setBackground(new Color(0, 0, 0, 150));
            JButton okBut = new JButton("OK");
            panel.add(okBut);
            background.add(panel);

            okBut.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    dispose();
                    parent.setVisible(true);
                }
            });

            Timer timer = new Timer(5000, new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    panel.setVisible(true);
                }
            });
            timer.setRepeats(false);
            timer.start();

            addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    System.exit(0);
                }
            });

            setUndecorated(true);
            pack();
            setLocationRelativeTo(parent);
            setVisible(true);
        }

        private ImageIcon createImage() {
            ImageIcon icon = null;
            try {
                URL url = new URL("http://www.iconsdb.com/icons/download/black/stackoverflow-2-256.png");
                icon = new ImageIcon(url);
            } catch (MalformedURLException ex) {
                Logger.getLogger(SplashDialogDemo.class.getName()).log(Level.SEVERE, null, ex);
            }
            return icon;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(SplashDialogDemo.class.getName()).log(Level.SEVERE, null, ex);
                }
                new SplashDialogDemo();
            }
        });
    }
}