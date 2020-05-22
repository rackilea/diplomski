import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class ex extends JFrame {

    public static void main(String[] args) {
        new ex();
    }

    ex() {
        super("test");
        // imagine this is actually using GridBagLayout
        JPanel ui = new JPanel(new GridLayout(0, 3,4,4));
        ui.setBorder(new EmptyBorder(4, 4, 4, 4));
        SpinnerModel sm = new SpinnerNumberModel(3, 1, 25, 1);
        JSpinner shiftIn = new JSpinner(sm);
        JLabel l = new JLabel("Shift Key"); 
        JPanel p = new JPanel(new BorderLayout());
        p.add(l, BorderLayout.PAGE_START);
        p.add(shiftIn, BorderLayout.PAGE_END);
        add(ui);

        for (int ii=0; ii<9; ii++) {
            if (ii==4) {
                ui.add(p);
            } else {
                ui.add(new JButton("Button"));
            }
        }

        pack();
        setVisible(true);
    }
}