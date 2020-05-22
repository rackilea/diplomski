import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import net.miginfocom.swing.MigLayout;

public class T extends JFrame {

    public T() {
        setSize(1000, 800);

        JPanel parentPanel = new JPanel(new MigLayout("", "grow, fill",
                "grow, fill"));
        parentPanel.setBackground(Color.GREEN);
        getContentPane().add(parentPanel);
        parentPanel.setSize(1000, 800);

        JPanel videoPanel = new JPanel();
        videoPanel.setBackground(Color.CYAN);

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new MigLayout("fillx", "[fill]", "[nogrid]"));
        contentPanel.setBackground(Color.YELLOW);

        parentPanel.getActionMap().put("enter", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Enter pressed, parent panel");
            }
        });

        InputMap inputMap = parentPanel.getInputMap();
        inputMap.put( KeyStroke.getKeyStroke(KeyEvent.VK_ENTER,0), "enter");

        parentPanel.add(videoPanel, "wmin 200");
        parentPanel.add(contentPanel);
    }


    public static void main(String[] args) {
        JFrame frame = new T();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}