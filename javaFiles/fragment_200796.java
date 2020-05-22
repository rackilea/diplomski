import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class ToggleColor extends JPanel {

    public ToggleColor() {
        JButton button = new JButton(new MyButtonAction());
        button.setBackground(Color.GREEN);
        add(button);
    }

    private static void createAndShowGui() {
        ToggleColor mainPanel = new ToggleColor();

        JFrame frame = new JFrame("ToggleColor");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}

@SuppressWarnings("serial")
class MyButtonAction extends AbstractAction {
    // !! parallel arrays being used below -- avoid if possible
    private static final String[] TEXT = {"First", "Second", "Third"};
    private static final Color[] COLORS = {Color.GREEN, Color.RED, new Color(108, 160, 220)};
    private int index = 0;

    public MyButtonAction() {
        super(TEXT[0]);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        index++;
        index %= TEXT.length;
        putValue(NAME, TEXT[index]);
        Component c = (Component) e.getSource();
        c.setBackground(COLORS[index]);
    }
}