import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class OptionPaneTest implements Runnable {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new OptionPaneTest());
    }

    @Override
    public void run() {
        JPanel p = new JPanel(new GridLayout(2, 1, 0, 10));
        JLabel infoLabel = new JLabel("Here is my info message");
        infoLabel.setIconTextGap(10);
        infoLabel.setIcon(UIManager.getIcon("OptionPane.informationIcon"));
        p.add(infoLabel);
        JLabel warnLabel = new JLabel("Here is my warning message");
        warnLabel.setIconTextGap(10);
        warnLabel.setIcon(UIManager.getIcon("OptionPane.warningIcon"));
        p.add(warnLabel);
        JOptionPane.showMessageDialog(null, p, "Here is my info and warn message", JOptionPane.PLAIN_MESSAGE);
        System.exit(0);
    }
}