import java.awt.*;
import javax.swing.*;

public class CustomPointerButtons {

    JPanel ui;

    CustomPointerButtons() {
        initUI();
    }

    private final void initUI() {
        ui = new JPanel(new BorderLayout(4, 4));

        JPanel topPanel = new JPanel(new BorderLayout(4, 4));

        ui.add(topPanel, BorderLayout.PAGE_START);
        ui.add(new JButton("Mister Mix")); //will default to CENTER

        topPanel.add(new JLabel("Blah, Blah.."));
        JButton back = getMinimalButton(new String(Character.toChars(9668)));
        topPanel.add(back, BorderLayout.LINE_START);

        JButton forward = getMinimalButton(new String(Character.toChars(9658)));
        topPanel.add(forward, BorderLayout.LINE_END);
    }

    public JButton getMinimalButton(String text) {
        JButton b = new JButton(text);
        b.setFont(b.getFont().deriveFont(40f));

        b.setMargin(new Insets(0,0,0,0));
        b.setContentAreaFilled(false);
        b.setBorder(null);

        return b;
    }

    public final JComponent getUI() {
        return ui;
    }


    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                JFrame f = new JFrame("Custom Pointer Buttons");
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                f.setContentPane(new CustomPointerButtons().getUI());
                f.pack();
                f.setLocationByPlatform(true);
                f.setVisible(true);
            }
        };
        SwingUtilities.invokeLater(r);
    }
}