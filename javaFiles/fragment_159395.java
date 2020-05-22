import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class ThreeButtonTextFieldCombo {

    private JPanel ui = null;

    ThreeButtonTextFieldCombo() {
        initUI();
    }

    public final void initUI() {
        if (ui!=null) return;
        ui = new JPanel(new GridBagLayout());
        ui.setBorder(new TitledBorder("Parent Panel"));

        JPanel controls = new JPanel(new GridLayout(1,0,10,10));
        ui.add(controls);
        controls.setBackground(Color.RED);
        controls.setBorder(new TitledBorder("Child Panel"));

        for (int ii=1; ii<4; ii++) {
            addLabelAndField(controls, "String " + ii);
        }
    } 

    public JComponent getUI() {
        return ui;
    }

    private void addLabelAndField(JPanel panel, String text) {
        JPanel controls = new JPanel(new BorderLayout(3, 3));
        controls.setBorder(new EmptyBorder(20,20,20,20));
        JLabel l = new JLabel(text);
        controls.add(l, BorderLayout.PAGE_START);

        JTextArea ta = new JTextArea(text, 2, 8);
        controls.add(new JScrollPane(ta));

        panel.add(controls);
    }

    public static void main(String[] args) {
        Runnable r = new Runnable() {

            @Override
            public void run() {
                JFrame f = new JFrame("Three Button/Text Field Combo");
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                f.setLocationByPlatform(true);
                ThreeButtonTextFieldCombo tbtfc = 
                        new ThreeButtonTextFieldCombo();
                f.setContentPane(tbtfc.getUI());
                f.pack();
                f.setMinimumSize(f.getSize());
                f.setVisible(true);
            }
        };
        SwingUtilities.invokeLater(r);
    }
}