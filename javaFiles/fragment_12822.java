import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class ColorCycler {

    private JComponent ui = null;
    Color[] colors = {
        Color.RED,
        Color.ORANGE,
        Color.YELLOW,
        Color.GREEN,
        Color.CYAN.darker(),
        Color.MAGENTA.darker(),
        Color.MAGENTA.darker().darker()
    };
    int counter = 0;
    JPanel[] panels = new JPanel[colors.length];

    ColorCycler() {
        initUI();
    }

    public void initUI() {
        if (ui!=null) return;

        ui = new JPanel(new BorderLayout(4,4));
        ui.setBorder(new EmptyBorder(4,4,4,4));
        ui.setBackground(Color.CYAN);

        ui.add(new JLabel(
                "Clock", SwingConstants.CENTER), BorderLayout.PAGE_START);
        ui.add(new JLabel(
                "Progress Bars", SwingConstants.CENTER), BorderLayout.PAGE_END);

        JPanel colorPanel = new JPanel(new GridLayout(0, 1));
        Border border = new EmptyBorder(new Insets(10, 200, 10, 200));
        for (int ii=0; ii<colors.length; ii++) {
            JPanel p = new JPanel();
            p.setBorder(border);
            panels[ii] = p;
            colorPanel.add(p);
        }
        ui.add(colorPanel, BorderLayout.CENTER);

        ActionListener colorListener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                counter++;
                setColors();
            }
        };
        final Timer colorCycleTimer = new Timer(50, colorListener);

        ActionListener delayListener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                colorCycleTimer.start();
            }
        };
        Timer delayTimer = new Timer(2000, delayListener);
        delayTimer.setRepeats(false);
        delayTimer.start();

        setColors();
    }

    private void setColors() {
        for (int ii=0; ii<colors.length; ii++) {
            panels[(counter+ii)%colors.length].setBackground(colors[ii]);
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
                ColorCycler o = new ColorCycler();

                JFrame f = new JFrame(o.getClass().getSimpleName());
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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