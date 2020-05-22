import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class FlushButtons {

    private JComponent ui = null;

    FlushButtons() {
        initUI();
    }

    private JButton getFlushButton(String text) {
        JButton b = new JButton();

        b.setBorderPainted(false);
        b.setContentAreaFilled(false);
        b.setMargin(new Insets(0,0,0,0));
        b.setBorder(null);
        b.setIcon(new ImageIcon(getImageOfText(text, Color.GREEN.darker())));
        b.setRolloverIcon(new ImageIcon(getImageOfText(text, Color.ORANGE)));
        b.setPressedIcon(new ImageIcon(getImageOfText(text, Color.RED)));

        return b;
    }

    private BufferedImage getImageOfText(String text, Color color) {
        int s = 24;
        BufferedImage bi = new BufferedImage(s, s, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = bi.createGraphics();

        g.setColor(color);
        g.fillRect(0, 0, s, s);
        g.setColor(Color.BLACK);
        g.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 16));
        // use better ways to position text..
        g.drawString(text, 8, 16);

        g.dispose();
        return bi;
    }

    public void initUI() {
        if (ui!=null) return;

        ui = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        ui.setBorder(new EmptyBorder(4,4,4,4));

        ui.add(getFlushButton("+"));
        ui.add(getFlushButton("-"));
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
                FlushButtons o = new FlushButtons();

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