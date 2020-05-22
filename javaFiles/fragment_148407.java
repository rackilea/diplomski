import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class FrameTest extends JFrame {

    private JTextField userText;
    private JButton imageButton;
    private JTextArea chatWindow;

    public FrameTest() {

        super("Test");

        userText = new JTextField();

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(userText, BorderLayout.CENTER);

        imageButton = new JButton("Problem Button");
        if (System.getProperty("os.name").equals("Mac OS X")) {

            imageButton.setLocation(455, 0);
            imageButton.setSize(150, 30);

        }

        else {

            imageButton.setLocation(435, 0);
            imageButton.setSize(150, 20);

        }

        topPanel.add(imageButton, BorderLayout.EAST);
        add(topPanel, BorderLayout.NORTH);
        chatWindow = new JTextArea();

        setSize(600, 300);
        setVisible(true);

    }

    public static void main(String[] args) {

        FrameTest test = new FrameTest();

    }

}