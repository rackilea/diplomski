import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class SplitPaneDivider {

    private JComponent ui = null;

    SplitPaneDivider() {
        initUI();
    }

    public void initUI() {
        if (ui != null) {
            return;
        }

        ui = new JPanel(new BorderLayout(4, 4));
        ui.setBorder(new EmptyBorder(4, 4, 4, 4));

        final JSplitPane sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
                new ColoredPanel(Color.GREEN),
                new ColoredPanel(Color.YELLOW));
        ui.add(sp);
        ActionListener dividerListener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                sp.setDividerLocation(.7d);
            }
        };
        Timer timer = new Timer(500, dividerListener);
        timer.setRepeats(false);
        timer.start();
    }

    class ColoredPanel extends JPanel {

        ColoredPanel(Color color) {
            setBackground(color);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 100);
        }
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
                SplitPaneDivider o = new SplitPaneDivider();

                JFrame f = new JFrame("Split Pane Divider");
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