import java.util.List;

import org.jfree.data.xy.XYDataItem;
import org.jfree.data.xy.XYSeries;

public class XYInterpolation
{
    public static void main(String[] args)
    {
        XYSeries s = new XYSeries("Series");

        s.add(0,0);
        s.add(1,2);
        s.add(2,5);

        double minX = -0.5;
        double maxX = 3.0;
        int steps = 35;
        for (int i=0; i<=steps; i++)
        {
            double a = (double)i / steps;
            double x = minX + a * (maxX - minX);
            double y = interpolate(s, x);
            System.out.printf("%8.3f : %8.3f\n", x, y);
        }
    }

    private static double interpolate(XYSeries s, double x)
    {
        if (x <= s.getMinX())
        {
            return s.getY(0).doubleValue();
        }
        if (x >= s.getMaxX())
        {
            return s.getY(s.getItemCount()-1).doubleValue();
        }
        List<?> items = s.getItems();
        for (int i=0; i<items.size()-1; i++)
        {
            XYDataItem i0 = (XYDataItem) items.get(i);
            XYDataItem i1 = (XYDataItem) items.get(i+1);
            double x0 = i0.getXValue();
            double y0 = i0.getYValue();
            double x1 = i1.getXValue();
            double y1 = i1.getYValue();

            if (x >= x0 && x <= x1)
            {
                double d = x - x0;
                double a = d / (x1-x0);
                double y = y0 + a * (y1 - y0);
                return y;
            }
        }
        // Should never happen
        return 0;
    }

}