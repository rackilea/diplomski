import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.Timer;
import javax.swing.UIManager;

/**
 * @see https://stackoverflow.com/a/12228640/230513
 * @see https://stackoverflow.com/a/7935040/230513
 */
public class GrayIcons extends JPanel {

    private List<Icon> list = new ArrayList<Icon>();
    private List<JToggleButton> buttons = new ArrayList<JToggleButton>();
    private Timer timer = new Timer(1000, new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            update();
        }
    });

    public GrayIcons() {
        this.setLayout(new GridLayout(1, 0));
        list.add(getGray(UIManager.getIcon("OptionPane.errorIcon")));
        list.add(getGray(UIManager.getIcon("OptionPane.informationIcon")));
        list.add(getGray(UIManager.getIcon("OptionPane.warningIcon")));
        list.add(getGray(UIManager.getIcon("OptionPane.questionIcon")));
        for (Icon icon : list) {
            JToggleButton jtb = new JToggleButton(icon);
            buttons.add(jtb);
            this.add(jtb);
        }
        timer.start();
    }

    private void update() {
        Collections.shuffle(list);
        int index = 0;
        for (JToggleButton b : buttons) {
            b.setIcon(list.get(index++));
        }
    }

    /**
     * @see https://stackoverflow.com/q/5830533/230513
     * @see https://stackoverflow.com/a/3106550/230513
     */
    private Icon getGray(Icon icon) {
        final int w = icon.getIconWidth();
        final int h = icon.getIconHeight();
        GraphicsEnvironment ge =
            GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gd = ge.getDefaultScreenDevice();
        GraphicsConfiguration gc = gd.getDefaultConfiguration();
        BufferedImage image = gc.createCompatibleImage(w, h);
        Graphics2D g2d = image.createGraphics();
        g2d.setPaint(new Color(0x00f0f0f0));
        g2d.fillRect(0, 0, w, h);
        icon.paintIcon(null, g2d, 0, 0);
        BufferedImage gray = new BufferedImage(w, h, BufferedImage.TYPE_BYTE_GRAY);
        ColorConvertOp op = new ColorConvertOp(
            image.getColorModel().getColorSpace(),
            gray.getColorModel().getColorSpace(), null);
        op.filter(image, gray);
        return new ImageIcon(gray);
    }

    private void display() {
        JFrame f = new JFrame("GrayIcons");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(this);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new GrayIcons().display();
            }
        });
    }
}