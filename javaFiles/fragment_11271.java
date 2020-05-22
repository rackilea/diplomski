import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Rectangle;
import org.jfree.chart.LegendItem;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        LegendItem item1 = new LegendItem("US", "US", "US", "US",
                new Rectangle(10, 10), new GradientPaint(0.0f, 0.0f,
                new Color(16, 89, 172), 0.0f, 0.0f, new Color(201, 201, 244)));

        System.out.println(item1.getSeriesIndex());
    }
}