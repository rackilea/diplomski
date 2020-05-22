import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class ChangeColor
{
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                new ChangeColor();
            }
        });
    }

    public ChangeColor()
    {
        JFrame frame = new JFrame();

        ColorPanel colorPanel = new ColorPanel(Color.BLUE);
        ColorInterpolator ci = new ColorInterpolator(colorPanel, Color.BLUE);

        colorPanel.addColorButton(createButton("Blue", Color.BLUE, ci));
        colorPanel.addColorButton(createButton("Green", Color.GREEN, ci));
        colorPanel.addColorButton(createButton("Red", Color.RED, ci));
        colorPanel.addColorButton(createButton("Cyan", Color.CYAN, ci));
        colorPanel.addColorButton(createButton("Yellow", Color.YELLOW, ci));
        colorPanel.addColorButton(createButton("Magenta", Color.MAGENTA, ci));

        frame.add(colorPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static JButton createButton(String name, final Color color, 
        final ColorInterpolator colorInterpolator)
    {
        JButton button = new JButton(name);
        button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                colorInterpolator.interpolateTo(color);
            }
        });
        return button;
    }


    /**
     * Creates an array with the given number of elements, that contains the
     * ARGB representations of colors that are linearly interpolated between the
     * given colors
     * 
     * @param steps The number of steps (the size of the resulting array)
     * @param colors The colors to interpolate between
     * @return The array with ARGB colors
     */
    static int[] createColorsArrayArgb(int steps, Color... colors)
    {
        int result[] = new int[steps];
        double normalizing = 1.0 / (steps - 1);
        int numSegments = colors.length - 1;
        double segmentSize = 1.0 / (colors.length - 1);
        for (int i = 0; i < steps; i++)
        {
            double relative = i * normalizing;
            int i0 = Math.min(numSegments, (int) (relative * numSegments));
            int i1 = Math.min(numSegments, i0 + 1);
            double local = (relative - i0 * segmentSize) * numSegments;

            Color c0 = colors[i0];
            int r0 = c0.getRed();
            int g0 = c0.getGreen();
            int b0 = c0.getBlue();

            Color c1 = colors[i1];
            int r1 = c1.getRed();
            int g1 = c1.getGreen();
            int b1 = c1.getBlue();

            int dr = r1 - r0;
            int dg = g1 - g0;
            int db = b1 - b0;

            int r = (int) (r0 + local * dr);
            int g = (int) (g0 + local * dg);
            int b = (int) (b0 + local * db);
            int argb = (0xFF << 24) | (r << 16) | (g << 8) | (b << 0);
            result[i] = argb;
        }
        return result;
    }
}

class ColorInterpolator
{
    private static final int DELAY = 20;

    private Color currentColor;
    private int currentIndex = 0;
    private int currentColorsArgb[];
    private final Timer timer;
    private final ColorPanel colorPanel;

    ColorInterpolator(final ColorPanel colorPanel, Color initialColor)
    {
        this.colorPanel = colorPanel;

        currentColor = initialColor;
        currentColorsArgb = new int[]{ initialColor.getRGB() };
        timer = new Timer(DELAY, new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                currentIndex++;
                if (currentIndex >= currentColorsArgb.length-1)
                {
                    timer.stop();
                    colorPanel.enableButtons();
                }
                else
                {
                    int argb = currentColorsArgb[currentIndex];
                    currentColor = new Color(argb);
                    colorPanel.setColor(currentColor);
                }
            }
        });
    }

    void interpolateTo(Color targetColor)
    {
        colorPanel.diableButtons();
        currentColorsArgb = ChangeColor.createColorsArrayArgb(
            40, currentColor, targetColor);
        currentIndex = 0;
        timer.start();
    }
}


class ColorPanel extends JPanel
{
    private Color currentColor;
    private List<JButton> buttons;

    public ColorPanel(Color initialColor)
    {
        currentColor = initialColor;
        buttons = new ArrayList<JButton>();
    }

    void addColorButton(JButton button)
    {
        buttons.add(button);
        add(button);
    }

    public void diableButtons()
    {
        for (JButton button : buttons)
        {
            button.setEnabled(false);
        }
    }

    public void enableButtons()
    {
        for (JButton button : buttons)
        {
            button.setEnabled(true);
        }
    }

    public void setColor(Color color)
    {
        currentColor = color;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setColor(currentColor);
        g.fillRect(0, 0, getWidth(), getHeight());
    }

    @Override
    public Dimension getPreferredSize()
    {
        return new Dimension(600, 300);
    }
}