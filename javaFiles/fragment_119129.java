import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class MyToggleButton extends JFrame {

    private static final long serialVersionUID = 1L;
    private Icon errorIcon = UIManager.getIcon("OptionPane.errorIcon");
    private Icon infoIcon = UIManager.getIcon("OptionPane.informationIcon");
    private Icon warnIcon = UIManager.getIcon("OptionPane.warningIcon");

    public MyToggleButton() {
        final JButton toggleButton = new JButton();
        toggleButton.setBorderPainted(false);
        toggleButton.setBorder(null);
        toggleButton.setFocusable(false);
        toggleButton.setMargin(new Insets(0, 0, 0, 0));
        toggleButton.setContentAreaFilled(false);
        toggleButton.setIcon((errorIcon));
        toggleButton.setSelectedIcon(infoIcon);
        toggleButton.setRolloverIcon((infoIcon));
        toggleButton.setPressedIcon(warnIcon);
        toggleButton.setDisabledIcon(warnIcon);
        add(toggleButton);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                MyToggleButton t = new MyToggleButton();
            }
        });
    }
}