import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class JButtonExample extends JPanel {

    final static int height = 500;
    final static int width = 500;
    JFrame frame = new JFrame();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(
                () -> new JButtonExample().start());
    }

    public void start() {
        File file = new File("your image file name here");
        try {
        Image img = ImageIO.read(file);
        ImageIcon icon = new ImageIcon(img);
        JButton button = new JButton(icon);
        add(button);
        setBackground(Color.white);
        button.addActionListener((ae)-> System.out.println("Button Clicked"));
        button.setPreferredSize(new Dimension(icon.getIconWidth(), icon.getIconHeight()));
        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }

    public JButtonExample() {
        frame.setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE);
        frame.add(this);
        setPreferredSize(
                new Dimension(width, height));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}