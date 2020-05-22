import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTree;
import javax.swing.RepaintManager;
import javax.swing.SwingUtilities;

public class TransparencyPanelTest
{
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }

    private static void createAndShowGui()
    {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().setLayout(new BorderLayout());

        OpacityPanel opacityPanel = new OpacityPanel();

        opacityPanel.setLayout(new BorderLayout());
        opacityPanel.add(new JLabel("Label"), BorderLayout.NORTH);
        opacityPanel.add(new JTree(), BorderLayout.CENTER);
        opacityPanel.add(new JButton("Button"), BorderLayout.SOUTH);

        f.getContentPane().add(opacityPanel, BorderLayout.CENTER);

        JSlider slider = new JSlider(0, 100, 50);
        slider.addChangeListener(e -> 
            opacityPanel.setOpacity(slider.getValue() / 100.0f));
        f.getContentPane().add(slider, BorderLayout.SOUTH);

        f.setSize(500,500);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

}

class OpacityPanel extends JPanel
{
    static
    {
        RepaintManager.setCurrentManager(new RepaintManager()
        {
            @Override
            public void addDirtyRegion(
                JComponent c, int x, int y, int w, int h)
            {
                Component cc = c;
                while (cc != null)
                {
                    if (cc instanceof OpacityPanel)
                    {
                        OpacityPanel p = (OpacityPanel)cc;
                        super.addDirtyRegion(
                            p, 0, 0, p.getWidth(), p.getHeight());
                    }
                    cc = cc.getParent();
                }
                super.addDirtyRegion(c, x, y, w, h);
            }
        });
    }
    private float opacity = 0.5f;
    private BufferedImage image;

    public OpacityPanel()
    {
        setOpaque(false);
    }

    public void setOpacity(float opacity)
    {
        this.opacity = Math.max(0.0f, Math.min(1.0f, opacity));
        repaint();
    }

    private void updateImage()
    {
        int w = Math.min(1, getWidth());
        int h = Math.min(1, getHeight());
        if (image == null || image.getWidth() != w || image.getHeight() != h)
        {
            image = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        }
        Graphics2D g = image.createGraphics();
        g.setColor(new Color(0,0,0,0));
        g.setComposite(AlphaComposite.SrcOver);
        g.fillRect(0, 0, w, h);
        g.dispose();
    }

    @Override
    protected void paintComponent(Graphics gr)
    {
        updateImage();
        Graphics2D imageGraphics = image.createGraphics();
        super.paintComponent(imageGraphics);
        imageGraphics.dispose();

        Graphics2D g = (Graphics2D) gr;
        g.setComposite(AlphaComposite.getInstance(
            AlphaComposite.SRC_OVER, opacity));
        g.drawImage(image, 0, 0, null);
    }

}