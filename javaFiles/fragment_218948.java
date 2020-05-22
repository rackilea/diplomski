import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.LineBorder;

public class TestLayout25 {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }
                try {
                    setUp();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    public static void setUp() throws IOException {
        JFrame frame = new JFrame();
        frame.setLayout(new GridBagLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Wheel of fortune");

        final JPanel scorePanel = new JPanel();
        final JPanel namePanel = new JPanel();
        final JPanel panel = new JPanel(new GridLayout(1, 3, 1, 1));
        final JPanel panel1 = new JPanel();
        final JPanel panel2 = new JPanel();
        final JPanel panel3 = new JPanel(new GridLayout(2, 1, 1, 1));

        panel3.add(new JLabel("Dead letters/phrases:"));
        panel3.add(createPane(Color.RED));

        scorePanel.add(new JLabel("Score Board:"));


        final WheelGui test = new WheelGui();
        final JPanel panel4 = test;
        panel4.setSize(800, 600);//this does nothing in the program

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        namePanel.add(new JLabel("Blue"), gbc);
        frame.getContentPane().add(namePanel, gbc);
        frame.getContentPane().add(scorePanel, gbc);
        frame.getContentPane().add(panel, gbc);
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        frame.getContentPane().add(panel4, gbc);
        gbc.weighty = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        frame.getContentPane().add(panel2, gbc);
        frame.getContentPane().add(panel1, gbc);
        frame.getContentPane().add(panel3, gbc);
        frame.setVisible(true);
    }

    protected static JPanel createPane(Color color) {

        JPanel panel = new JPanel();
        panel.setBorder(new LineBorder(color));
        return panel;

    }

    public static class WheelGui extends JPanel {

        ImageIcon image = new ImageIcon("WheelofFortune.JPG");
        JPanel rotationPanel;
        final int WIDTH = 800;
        final int HEIGHT = 600;
        static double degrees;

        public WheelGui() {
            super();
            this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
            setBackground(Color.lightGray);
            setLayout(null);
            setFocusable(true);
            rotationPanel = new JPanel();

            rotationPanel = new turningCanvas();
            rotationPanel.setPreferredSize(new Dimension(image.getIconWidth(), image.getIconHeight()));
            //rotationPanel.setSize(800,600);  
            add(rotationPanel);
            rotationPanel.setBounds(WIDTH / 8, HEIGHT / 8, rotationPanel.getPreferredSize().width, rotationPanel.getPreferredSize().height);
            degrees = 0;
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
        }

        public class turningCanvas extends JPanel {

            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.rotate(Math.toRadians(degrees), image.getIconWidth() / 2, image.getIconHeight() / 2);
                image.paintIcon(this, g2d, 0, 0);

            }
        }

        public void rotate() {
            for (int i = 0; i < 360; i += 4) {
                degrees++;
                repaint();
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }
}