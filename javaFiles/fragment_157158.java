import java.awt.*;
import javax.swing.*;

public class TranslucentWindow extends JFrame {

    private static final long serialVersionUID = 1L;

    public TranslucentWindow() {
        super("Test translucent window");
        setLayout(new FlowLayout());
        add(new JButton("test"));
        add(new JCheckBox("test"));
        add(new JRadioButton("test"));
        add(new JProgressBar(0, 100));
        JPanel panel = new JPanel() {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(400, 300);
            }
            private static final long serialVersionUID = 1L;

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.red);
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        panel.add(new JLabel("Very long textxxxxxxxxxxxxxxxxxxxxx "));
        add(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        pack();
        setLocationRelativeTo(null);
        setOpacity(0.70f);
    }

    public static void main(String[] args) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //JFrame.setDefaultLookAndFeelDecorated(true);
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Window w = new TranslucentWindow();
                w.setVisible(true);
            }
        });
    }
}