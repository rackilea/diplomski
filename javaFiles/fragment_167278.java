import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Dlg extends JDialog {
    public Dlg(JFrame frame, String str) {
        super(frame, str);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        try {
            Dlg frame = new Dlg(new JFrame(), "No min max buttons");
            JPanel panel = new JPanel();
            panel.setSize(200, 200);
            JLabel lbl = new JLabel("blah blah");
            panel.add(lbl);
            frame.add(panel);
            frame.setSize(400, 400);
            frame.setVisible(true);
        } catch (IllegalArgumentException e) {
            System.exit(0);
        }
    }
}