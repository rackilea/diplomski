import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;

public class NotificationPopup {

    private static final long serialVersionUID = 1L;
    private LinearGradientPaint lpg;
    private JDialog dialog = new JDialog();
    private BackgroundPanel panel = new BackgroundPanel();

    public NotificationPopup() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Insets scnMax = Toolkit.getDefaultToolkit().
                getScreenInsets(dialog.getGraphicsConfiguration());
        int taskBarSize = scnMax.bottom;
        panel.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 1.0f;
        constraints.weighty = 1.0f;
        constraints.insets = new Insets(5, 5, 5, 5);
        constraints.fill = GridBagConstraints.BOTH;
        JLabel l = new JLabel("You have got 2 new Messages.");
        panel.add(l, constraints);
        constraints.gridx++;
        constraints.weightx = 0f;
        constraints.weighty = 0f;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.NORTH;
        JButton b = new JButton(new AbstractAction("x") {

            private static final long serialVersionUID = 1L;

            @Override
            public void actionPerformed(final ActionEvent e) {
                dialog.dispose();
            }
        });
        b.setOpaque(false);
        b.setMargin(new Insets(1, 4, 1, 4));
        b.setFocusable(false);
        panel.add(b, constraints);
        dialog.setUndecorated(true);
        dialog.setSize(300, 100);
        dialog.setLocation(screenSize.width - dialog.getWidth(),
                screenSize.height - taskBarSize - dialog.getHeight());
        lpg = new LinearGradientPaint(0, 0, 0, dialog.getHeight() / 2,
                new float[]{0f, 0.3f, 1f}, new Color[]{new Color(0.8f, 0.8f, 1f),
                    new Color(0.7f, 0.7f, 1f), new Color(0.6f, 0.6f, 1f)});
        dialog.setContentPane(panel);
        dialog.setVisible(true);
    }

    private class BackgroundPanel extends JPanel {

        private static final long serialVersionUID = 1L;

        BackgroundPanel() {
            setOpaque(true);
        }

        @Override
        protected void paintComponent(final Graphics g) {
            final Graphics2D g2d = (Graphics2D) g;
            g2d.setPaint(lpg);
            g2d.fillRect(1, 1, getWidth() - 2, getHeight() - 2);
            g2d.setColor(Color.BLACK);
            g2d.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
        }
    }

    public static void main(final String[] args) {
        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                System.out.println(info.getName());
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (UnsupportedLookAndFeelException e) {
        } catch (ClassNotFoundException e) {
        } catch (InstantiationException e) {
        } catch (IllegalAccessException e) {
        }
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {

                NotificationPopup notificationPopup = new NotificationPopup();
            }
        });
    }
}