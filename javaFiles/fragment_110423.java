import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.InputEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.image.BufferedImage;
import java.beans.Transient;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class ImageBulgeTest
{
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI()
    {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new GridLayout(1, 1));
        frame.getContentPane().add(new ImageBulgePanel());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}


class ImageBulgePanel extends JPanel
{
    private BufferedImage input;
    private BufferedImage output;
    private double bulgeStrength = 0.3;
    private double bulgeRadius = 100;

    ImageBulgePanel()
    {
        try
        {
            input = ImageIO.read(new File("lena512color.png"));
        }
        catch (IOException e1)
        {
            e1.printStackTrace();
        }

        addMouseMotionListener(new MouseAdapter()
        {
            @Override
            public void mouseMoved(MouseEvent e)
            {
                updateImage(e.getX(), e.getY());
            }
        });
        addMouseWheelListener(new MouseWheelListener()
        {

            @Override
            public void mouseWheelMoved(MouseWheelEvent e)
            {
                if ((e.getModifiersEx() & InputEvent.SHIFT_DOWN_MASK) ==
                    InputEvent.SHIFT_DOWN_MASK)
                {
                    bulgeRadius += 10 * e.getWheelRotation();
                    System.out.println("bulgeRadius "+bulgeRadius);
                }
                else
                {
                    bulgeStrength += 0.1 * e.getWheelRotation();
                    bulgeStrength = Math.max(0, bulgeStrength);
                    System.out.println("bulgeStrength "+bulgeStrength);
                }
                updateImage(e.getX(), e.getY());
            }
        });
    }

    @Override
    @Transient
    public Dimension getPreferredSize()
    {
        if (isPreferredSizeSet())
        {
            return super.getPreferredSize();
        }
        return new Dimension(input.getWidth(), input.getHeight());
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        if (output != null)
        {
            g.drawImage(output, 0, 0, null);
        }
    }

    private void updateImage(int x, int y)
    {
        if (output == null)
        {
            output = new BufferedImage(
                input.getWidth(), input.getHeight(), 
                BufferedImage.TYPE_INT_ARGB);
        }
        computeBulgeImage(input, x, y, 
            bulgeStrength, bulgeRadius, 
            output);
        repaint();
    }

    private static void computeBulgeImage(
        BufferedImage input, int cx, int cy, 
        double bulgeStrength, double bulgeRadius, 
        BufferedImage output)
    {
        int w = input.getWidth();
        int h = input.getHeight();
        for(int x = 0; x < w; x++)
        {
            for(int y = 0; y < h; y++)
            {
                int dx = x-cx;
                int dy = y-cy;
                double distanceSquared = dx * dx + dy * dy;;
                int sx = x;
                int sy = y;
                if (distanceSquared < bulgeRadius * bulgeRadius)
                {
                    double distance = Math.sqrt(distanceSquared);
                    boolean otherMethod = false;
                    otherMethod = true;
                    if (otherMethod)
                    {
                        double r = distance / bulgeRadius;
                        double a = Math.atan2(dy, dx);
                        double rn = Math.pow(r, bulgeStrength)*distance; 
                        double newX = rn*Math.cos(a) + cx; 
                        double newY = rn*Math.sin(a) + cy;  
                        sx += (newX - x);
                        sy += (newY - y);
                    }
                    else
                    {
                        double dirX = dx / distance;
                        double dirY = dy / distance;
                        double alpha = distance / bulgeRadius;
                        double distortionFactor = 
                            distance * Math.pow(1-alpha, 1.0 / bulgeStrength);
                        sx -= distortionFactor * dirX;
                        sy -= distortionFactor * dirY;
                    }
                }
                if (sx >= 0 && sx < w && sy >= 0 && sy < h)
                {
                    int rgb = input.getRGB(sx, sy);
                    output.setRGB(x, y, rgb);
                }
            }
        }
    }
}