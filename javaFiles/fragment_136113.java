import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public class Test {

    public static void main(String[] args) {
        MainGUI mainGUI = MainGUI.getInstance();
    }
}
class MainGUI {

    private JFrame frame;

    private static class SingletonHolder {

        public static final MainGUI INSTANCE = new MainGUI();
    }

    public static MainGUI getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private MainGUI() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                frame = createJFrame();
                frame.setVisible(true);
            }
        });
    }

    private JFrame createJFrame() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Test");

        frame.add(new Panel1());//initial Jpanel to display

        frame.pack();
        return frame;
    }

    public void swapPanel(JPanel p) {
        frame.getContentPane().removeAll();
        frame.add(p);
        frame.pack();
        frame.revalidate();
        frame.repaint();
    }
}

class Panel1 extends JPanel {

    public Panel1() {
        JLabel labelPanel1 = new JLabel("Panel 1");
        JButton switchPanelButton = new JButton("Goto Panel 2");
        switchPanelButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainGUI.getInstance().swapPanel(new Panel2());
            }
        });
        add(labelPanel1);
        add(switchPanelButton);
    }
}

class Panel2 extends JPanel {

    public Panel2() {
        JLabel labelPanel1 = new JLabel("Panel 2");
        JButton switchPanelButton = new JButton("Goto Panel 1");
        switchPanelButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainGUI.getInstance().swapPanel(new Panel1());
            }
        });
        add(labelPanel1);
        add(switchPanelButton);
    }
}