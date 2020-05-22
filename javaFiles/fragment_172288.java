import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class ResponsiveGUI {

    private JComponent ui = null;

    ResponsiveGUI() {
        initUI();
    }

    public void initUI() {
        if (ui!=null) return;

        ui = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 8));
        ui.setBorder(new EmptyBorder(10,40,10,40));

        for (int i=1; i<3; i++) {
            ui.add(getBigButton(i));
        }
    }

    public JComponent getUI() {
        return ui;
    }

    private final JButton getBigButton(int number) {
        JButton b = new JButton("Button " + number);
        int pad = 20;
        b.setMargin(new Insets(pad, pad, pad, pad));

        return b;
    }

    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception useDefault) {
                }
                ResponsiveGUI o = new ResponsiveGUI();

                JFrame f = new JFrame("Responsive GUI");
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                f.setLocationByPlatform(true);

                f.setContentPane(o.getUI());
                f.pack();

                f.setVisible(true);
            }
        };
        SwingUtilities.invokeLater(r);
    }
}