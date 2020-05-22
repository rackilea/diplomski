import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class JFrameMaximize extends JFrame {

    public JFrameMaximize() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        // A fake panel representing many swing components
        panel.setPreferredSize(new Dimension(333, 666));
        panel.setBorder(BorderFactory.createLineBorder(Color.blue, 10));
        this.add(panel);
        this.pack();
        // Now we want to set the Extended State, if supported
        if (Toolkit.getDefaultToolkit().isFrameStateSupported(MAXIMIZED_BOTH)) {
            System.out.println("Frame state supported.");
            this.setExtendedState(MAXIMIZED_BOTH);
        } else {
            System.out.println("Frame state not supported.");
            Dimension max = Toolkit.getDefaultToolkit().getScreenSize();
            // TODO see getMaximumWindowBounds()
            max.height -= 20;
            this.setSize(max);
            this.setLocation(0, 20);
        }
        this.setVisible(true);
    }

    public static void main(String... args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new JFrameMaximize();
            }
        });
    }
}