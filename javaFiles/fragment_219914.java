import java.awt.*;
import javax.swing.*;

public class FrameTestBase extends JFrame {

    public static void main(String args[]) {
        FrameTestBase t = new FrameTestBase();

        JPanel mainPanel = new JPanel(new BorderLayout());

        // Create some component
        JLabel l = new JLabel("hello world");
        l.setOpaque(true);
        l.setBackground(Color.RED);

        JPanel extraPanel = new JPanel(new FlowLayout());
        l.setPreferredSize(new Dimension(100, 100));
        extraPanel.setBackground(Color.GREEN);

        // Instead of adding l to the mainPanel (BorderLayout),
        // add it to the extra panel
        extraPanel.add(l);

        // Now add the extra panel instead of l
        mainPanel.add(extraPanel, BorderLayout.CENTER);

        t.setContentPane(mainPanel);

        t.setDefaultCloseOperation(EXIT_ON_CLOSE);
        t.setSize(400, 200);
        t.setVisible(true);
    }
}