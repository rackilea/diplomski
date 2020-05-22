import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class TwoPanelWithButtonsLayout {

    private JComponent ui = null;
    private Insets buttonMargin = new Insets(10,10,10,10);

    TwoPanelWithButtonsLayout() {
        initUI();
    }

    public void initUI() {
        if (ui!=null) return;

        ui = new JPanel(new BorderLayout(4,4));
        ui.setBorder(new EmptyBorder(4,4,4,4));

        int gap = 5;

        JPanel buttons1 = new JPanel(new GridLayout(2, 4, gap, gap));
        // 50 is the gap on right, alter as needed
        buttons1.setBorder(new EmptyBorder(0, 0, 0, 50)); 
        for (int ii=1; ii<9; ii++) {
            buttons1.add(getBigButton("" + ii));
        }
        ui.add(buttons1, BorderLayout.CENTER);

        JPanel buttons2 = new JPanel(new GridLayout(2, 2, gap, gap));
        for (int ii=1; ii<5; ii++) {
            buttons2.add(getBigButton("" + ii));
        }
        ui.add(buttons2, BorderLayout.LINE_END);
    }

    private JButton getBigButton(String text) {
        JButton b = new JButton(text);
        Font f = b.getFont();
        b.setFont(f.deriveFont(f.getSize()*3f));
        b.setMargin(buttonMargin);
        return b;
    }

    public JComponent getUI() {
        return ui;
    }

    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception useDefault) {
                }
                TwoPanelWithButtonsLayout o = new TwoPanelWithButtonsLayout();

                JFrame f = new JFrame(o.getClass().getSimpleName());
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                f.setLocationByPlatform(true);

                f.setContentPane(o.getUI());
                f.pack();
                f.setMinimumSize(f.getSize());

                f.setVisible(true);
            }
        };
        SwingUtilities.invokeLater(r);
    }
}