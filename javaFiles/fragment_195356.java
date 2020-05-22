import java.awt.*;
import javax.swing.*;

public class ResizeIconInButton extends JFrame {

    private static final long serialVersionUID = 1L;
    private static final String IMAGE_PATH = "http://duke.kenai.com/misc/Bullfight.jpg";
    private JButton myButton = new JButton();
    private JLabel myLabel = new JLabel();

    public ResizeIconInButton() {
        Icon myIcon = new ImageIcon(IMAGE_PATH);
        myLabel.setIcon(myIcon);
        myButton.setLayout(new BorderLayout());
        myButton.add(myLabel);
        add(myButton, BorderLayout.CENTER);
        setPreferredSize(new Dimension(200, 100));
        setTitle("Resize Icon In Button");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                ResizeIconInButton main = new ResizeIconInButton();
            }
        });
    }
}