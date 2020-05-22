import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Frame {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                Frame frame = new Frame();
            }
        });
    }

    private final int WIDTH = 1024;
    private final int HEIGHT = 768;
    private JFrame frame;
    private JPanel panel;
    private JLabel human;
    private JTextArea text;

    public Frame() {
        this.frame = new JFrame();
        this.panel = new JPanel();
        this.human = ImageSize(200, 200, "res/human.png");
        this.text = new JTextArea("You have lost in the forest. Now you have to find "
                        + "your way back.");

        //frame setup
        frame.setTitle("Shady Path");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // That's pointless
        //frame.setLayout(new BorderLayout());
        // That's pointless
        //frame.pack();
        frame.setSize(WIDTH, HEIGHT);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setResizable(false);

        //main text setup
        Font font = new Font(Font.MONOSPACED, Font.PLAIN, 20);
        text.setEditable(false);
        text.setForeground(Color.WHITE);
        text.setFont(font);
        text.setLineWrap(true);
        text.setWrapStyleWord(true);
        text.setMargin(new Insets(0, 300, 0, 300));
        text.setOpaque(false);

        //button setup
        JButton button = new JButton();
        JLabel playButton = new JLabel("Play");
        playButton.setFont(font);
        playButton.setForeground(Color.WHITE);
        playButton.add(button);

        //panel setup and adding elements
        panel.setLayout(new GridBagLayout());
        panel.setOpaque(false);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.weightx = 1.0;
        gbc.insets = new Insets(50, 0, 0, 0);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        panel.add(human, gbc);

        gbc.insets = new Insets(30, 0, 0, 0);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(text, gbc);

        gbc.fill = GridBagConstraints.NONE;
        panel.add(playButton, gbc);

        frame.add(panel);
        frame.setVisible(true);
    }

    private JLabel ImageSize(int x, int y, String fileName) //Method for image resizing
    {
        BufferedImage baseImg = new BufferedImage(x, y, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = baseImg.createGraphics();
        g2d.setColor(Color.RED);
        g2d.fillRect(0, 0, x, y);
        g2d.dispose();
//      try {
//          baseImg = ImageIO.read(new File(fileName));
//      } catch (IOException e) {
//          e.printStackTrace();
//      }
//      Image resizedImg = baseImg.getScaledInstance(x, y, Image.SCALE_SMOOTH);
//      ImageIcon IconImg = new ImageIcon(resizedImg);
        JLabel imageLabel = new JLabel(new ImageIcon(baseImg));
        return imageLabel;
    }
}