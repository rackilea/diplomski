import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class BarChart extends JPanel
{
    public static void main(String[] args)
    {
        int[] p = new int[]{100, 5, 6, 9, 1, 0, 5, 100};
        JFrame f = new JFrame();
        f.setBackground(Color.BLUE);
        BarChart chart = new BarChart(p);
        chart.setBackground(Color.RED);
        f.add(chart);
        f.pack();
        f.show();
    }

    private int[] percentage;
    private Color color;
    private boolean padEnds = true;

    public BarChart(int[] percentage, Color color)
    {
        this.percentage = percentage;
        this.color = color;
        return;
    }

    public BarChart(int[] percentage)
    {
        this(percentage, Color.BLACK);
        return;
    }

    public BarChart()
    {
        this(new int[0]);
        return;
    }

    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        g.setColor(this.color);

        int width = super.getWidth();
        int height = super.getHeight();
        int topPadding = Math.round(height * 0.05f);

        int barCount = this.percentage.length;

        int barOffset = Math.round(width * 0.025f); // 2.5% (in pixels) reserved space on both sides of each bar == 5% between bars
        int totalOffsetWidth = (barOffset * 2) * barCount;

        if (!this.padEnds)
        {
            totalOffsetWidth -= (barOffset * 2);
        }

        int availableWidth = width - totalOffsetWidth;
        int availableHeight = height - topPadding;

        int barWidth = (int) Math.floor((float) availableWidth / (float) barCount);

        int xLeft = 0;

        for (int i = 0; i < barCount; i++)
        {
            int percent = this.percentage[i];

            if (this.padEnds || (i != 0))
            {
                xLeft += barOffset; // Add offset here to pad left side of each bar.
            }

            int barHeight = Math.round(((float) availableHeight) * ((float) percent / 100f));

            int yTop = topPadding + (availableHeight - barHeight);

            g.fillRect(xLeft, yTop, barWidth, barHeight);

            xLeft += barWidth; // advance the next drawing position

            if (this.padEnds || (i != (barCount - 1)))
            {
                xLeft += barOffset; // Add offset here to pad right side of each bar.
            }
        }

        return;
    }
}