import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class TestGlassPaneAnimation {

    private static GlassValidationPane gvp = new GlassValidationPane();

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame f = new JFrame("Anitest in glass");
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                //f.setResizable(false);
                f.setLayout(new GridBagLayout());

                GridBagConstraints gc = new GridBagConstraints();
                gc.fill = GridBagConstraints.HORIZONTAL;
                gc.weightx = 1;
                gc.weighty = 1;
                gc.insets = new Insets(15, 15, 15, 15);//give some space so icon doesnt cover components when shown

                gc.gridx = 0;
                gc.gridy = 0;
                f.add(new JLabel("First Name:"), gc);

                final JTextField jtf = new JTextField(20);
                gc.gridx = 1;
                f.add(jtf, gc);

                gc.gridx = 0;
                gc.gridy = 1;
                f.add(new JLabel("Surname:"), gc);

                final JTextField jtf2 = new JTextField(20);
                gc.gridx = 1;
                f.add(jtf2, gc);

                JButton btnStart = new JButton("Click me, please!");
                gc.gridx = 2;
                f.add(btnStart, gc);

                btnStart.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (!jtf.getText().equalsIgnoreCase("david")) {
                            gvp.showWarningIcon(jtf);
                        }
                    }
                });

                f.addComponentListener(new ComponentAdapter() {//so wjen frame is resized icons follow
                    @Override
                    public void componentResized(ComponentEvent ce) {
                        super.componentResized(ce);
                        gvp.refreshLocations();
                    }
                });
                f.setGlassPane(gvp);

                f.pack();
                f.setVisible(true);
                gvp.setVisible(true);
            }
        });
    }
}

class GlassValidationPane extends JPanel {

    private HashMap<Component, JLabel> warningLabels = new HashMap<>();
    private ImageIcon warningIcon;

    public GlassValidationPane() {
        setLayout(null);//this is the exception to the rule case a layoutmanager might make setting Jlabel co-ords harder
        setOpaque(false);
        Icon icon = UIManager.getIcon("OptionPane.warningIcon");
        int imgW = icon.getIconWidth();
        int imgH = icon.getIconHeight();
        BufferedImage img = ImageUtilities.getBufferedImageOfIcon(icon, imgW, imgH);
        warningIcon = new ImageIcon(ImageUtilities.resize(img, 24, 24));
    }

    void showWarningIcon(Component c) {
        if (warningLabels.containsKey(c)) {
            return;
        }

        JLabel label = new JLabel();
        label.setIcon(warningIcon);

        //int x=c.getX();//this will make it insode the component
        int x = c.getX() - warningIcon.getIconWidth();//this makes it appear outside/next to component if space
        int y = c.getY();

        label.setBounds(x, y, warningIcon.getIconWidth(), warningIcon.getIconHeight());
        add(label);
        revalidate();
        repaint();
        warningLabels.put(c, label);
    }

    public void removeWarningIcon(Component c) {
        for (Map.Entry<Component, JLabel> entry : warningLabels.entrySet()) {
            Component component = entry.getKey();
            JLabel jLabel = entry.getValue();
            if (component == c) {
                remove(jLabel);
                revalidate();
                repaint();
                break;
            }
        }
        warningLabels.remove(c);
    }

    public void refreshLocations() {
        for (Map.Entry<Component, JLabel> entry : warningLabels.entrySet()) {
            Component c = entry.getKey();
            JLabel label = entry.getValue();
            //int x=c.getX();//this will make it insode the component
            int x = c.getX() - label.getIcon().getIconWidth();//this makes it appear outside/next to component
            int y = c.getY();

            label.setBounds(x, y, label.getIcon().getIconWidth(), label.getIcon().getIconHeight());
            revalidate();
            repaint();
        }
    }
}

class ImageUtilities {

    public static BufferedImage resize(BufferedImage image, int width, int height) {
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TRANSLUCENT);
        Graphics2D g2d = (Graphics2D) bi.createGraphics();
        g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
        g2d.drawImage(image, 0, 0, width, height, null);
        g2d.dispose();
        return bi;
    }

    public static BufferedImage getBufferedImageOfIcon(Icon icon, int imgW, int imgH) {
        BufferedImage img = new BufferedImage(imgW, imgH, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = (Graphics2D) img.getGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        icon.paintIcon(null, g2d, 0, 0);
        g2d.dispose();
        return img;
    }
}