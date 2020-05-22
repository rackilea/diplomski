import java.awt.*;
import javax.swing.*;
import java.net.*;

public final class Tester  extends JFrame {
    public static void main(String[] args) throws MalformedURLException {
        new Tester();
    }

    private Tester() throws MalformedURLException {
        setTitle("Tester");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Icon backgroundIcon = new ImageIcon(
                new URL("http://1point1c.org/gif/moon/moonphases.gif"));
        Icon foregroundIcon = new ImageIcon(
                new URL("http://1point1c.org/gif/thum/plnttm.gif"));

        JLabel background = new JLabel(backgroundIcon);
        JLabel foreground = new JLabel(foregroundIcon);

        background.setLayout(new GridBagLayout());
        background.add(foreground);
        add(background);

        pack();

        setLocationByPlatform(true);
        setVisible(true);
    }
}