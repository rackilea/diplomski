/*
<applet
  code='FixedSizeLayout'
  width='200'
  height='150'>
</applet>
*/
import java.awt.*;
import javax.swing.*;

public class FixedSizeLayout extends JApplet {
    public void init() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                initGui();
            }
        });
    }

    private void initGui() {
        JTabbedPane tb = new JTabbedPane();
        tb.addTab("Rcon Details", new RconSection());

        setContentPane(tb);
        validate();
    }
}

class RconSection extends JPanel {
    private static String TEST_COMMAND = "test";
    private static String CLEAR_COMMAND = "clear";
    private static JTextField ipText = new JTextField();
    private static JTextField portText = new JTextField();
    private static JTextField rPassText = new JTextField();

    public RconSection() {
        super(new BorderLayout(3,3));
        JLabel ip = new JLabel("IP");
        JLabel port = new JLabel("Port");
        JLabel rPass = new JLabel("Rcon Password");

        JButton testButton = new JButton("Test");
        testButton.setActionCommand(TEST_COMMAND);

        JButton clearButton = new JButton("Clear");
        clearButton.setActionCommand(CLEAR_COMMAND);

        JPanel panel = new JPanel(new GridLayout(3,2));
        panel.add(ip);
        panel.add(ipText);
        panel.add(port);
        panel.add(portText);
        panel.add(rPass);
        panel.add(rPassText);

        JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.CENTER,5,5));
        panel1.add(testButton);
        panel1.add(clearButton);

        add(panel, BorderLayout.CENTER);
        add(panel1, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Container c = new RconSection();
                JOptionPane.showMessageDialog(null, c);
            }
        });
    }
}