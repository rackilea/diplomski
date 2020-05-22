import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.image.BufferedImage;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.plaf.basic.BasicDesktopIconUI;

class SimpleDesktopIconUI extends BasicDesktopIconUI
{
    private final Icon icon;

    SimpleDesktopIconUI(Icon icon)
    {
        this.icon = icon;
    }

    @Override
    protected void installComponents()
    {
        frame = desktopIcon.getInternalFrame();
        String title = frame.getTitle();

        JLabel label = new JLabel(title, icon, SwingConstants.CENTER);
        label.setVerticalTextPosition(JLabel.BOTTOM);
        label.setHorizontalTextPosition(JLabel.CENTER);

        desktopIcon.setBorder(null);
        desktopIcon.setOpaque(false);
        desktopIcon.setLayout(new GridLayout(1, 1));
        desktopIcon.add(label);
    }

    @Override
    protected void uninstallComponents()
    {
        desktopIcon.setLayout(null);
        desktopIcon.removeAll();
        frame = null;
    }

    @Override
    public Dimension getMinimumSize(JComponent c)
    {

        LayoutManager layout = desktopIcon.getLayout();
        Dimension size = layout.minimumLayoutSize(desktopIcon);
        return new Dimension(size.width + 15, size.height + 15);
    }

    @Override
    public Dimension getPreferredSize(JComponent c)
    {
        return getMinimumSize(c);
    }

    @Override
    public Dimension getMaximumSize(JComponent c)
    {
        return getMinimumSize(c);
    }
}

public class InternalFrameIconTest
{
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    private static void createAndShowGUI()
    {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Icon icon = new ImageIcon(createImage());

        JDesktopPane desktopPane = new JDesktopPane();

        for (int i = 0; i < 5; i++)
        {
            String title = "Test " + i;
            if (i == 2)
            {
                title = "Test 2 with longer title";
            }
            JInternalFrame internalFrame =
                new JInternalFrame(title, true, true, true, true);
            internalFrame.setBounds(20 + 50 * i, 300 - 40 * i, 160, 80);
            internalFrame.setVisible(true);
            desktopPane.add(internalFrame);

            internalFrame.getDesktopIcon().setUI(new SimpleDesktopIconUI(icon));
        }

        f.getContentPane().add(desktopPane);
        f.setSize(600, 600);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    private static BufferedImage createImage()
    {
        int w = 50;
        int h = 50;
        BufferedImage image =
            new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = image.createGraphics();
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, w, h);
        g.setColor(Color.RED);
        g.drawLine(0, 0, w, h);
        g.drawLine(0, h, w, 0);
        g.dispose();
        return image;
    }
}