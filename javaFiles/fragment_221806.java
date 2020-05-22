import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class BackgroundImageForCardLayout {

    private JComponent ui = null;
    private Image image= new BufferedImage(400,300,BufferedImage.TYPE_INT_RGB);

    BackgroundImageForCardLayout() {
        initUI();
    }

    public void initUI() {
        if (ui!=null) return;

        ui = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        };

        final CardLayout cl = new CardLayout();
        ui.setLayout(cl);

        final String[] names = {"Card 1", "Card 2", "Card 3"};
        for (String name : names) {
            JPanel p = new JPanel(new GridLayout());
            p.setOpaque(false);
            p.add(getBigColoredLabel(name));
            p.setOpaque(false);
            ui.add(p, name);
        }
        ActionListener animationListener = new ActionListener() {

            int i=0;

            @Override
            public void actionPerformed(ActionEvent e) {
                String name = names[i%names.length];
                cl.show(ui, name);
                i++;
            }
        };
        Timer timer = new Timer(750, animationListener);
        timer.start();
    }

    private final JLabel getBigColoredLabel(String text) {
        JLabel l = new JLabel(text, SwingConstants.CENTER);
        l.setForeground(Color.RED);
        Font f = l.getFont();
        l.setFont(f.deriveFont(120f));
        return l;
    }

    public JComponent getUI() {
        return ui;
    }

    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(
                            UIManager.getSystemLookAndFeelClassName());
                } catch (Exception useDefault) {
                }
                BackgroundImageForCardLayout o = 
                        new BackgroundImageForCardLayout();

                JFrame f = new JFrame("Background Image for CardLayout");
                // Hack to terminate the Timer on close.
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