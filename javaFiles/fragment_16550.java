import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.font.FontRenderContext;
import java.awt.font.LineMetrics;
import java.awt.geom.Rectangle2D;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import org.jfree.chart.axis.AxisState;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.DateTickUnit;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.ui.RectangleEdge;
import org.jfree.chart.ui.RectangleInsets;
import org.jfree.data.time.DateRange;

public class CorrectedDateAxis extends DateAxis {

    /** For serialization. */
    private static final long serialVersionUID = 0L;


    /**
     * Creates a date axis with no label.
     */
    public CorrectedDateAxis() {
        super(null);
    }

    /**
     * Creates a date axis with the specified label.
     *
     * @param label  the axis label ({@code null} permitted).
     */
    public CorrectedDateAxis(String label) {
        super(label);
    }

    /**
     * Creates a date axis.
     *
     * @param label  the axis label ({@code null} permitted).
     * @param zone  the time zone.
     * @param locale  the locale ({@code null} not permitted).
     */
    public CorrectedDateAxis(String label, TimeZone zone, Locale locale) {
        super(label, zone, locale);
    }

    /**
     * Estimates the maximum width of the tick labels, assuming the specified
     * tick unit is used.
     * <P>
     * Rather than computing the string bounds of every tick on the axis, we
     * just look at two values: the lower bound and the upper bound for the
     * axis.  These two values will usually be representative.
     *
     * @param g2  the graphics device.
     * @param unit  the tick unit to use for calculation.
     *
     * @return The estimated maximum width of the tick labels.
     */
    private double estimateMaximumTickLabelWidth(Graphics2D g2, 
            DateTickUnit unit) {

        RectangleInsets tickLabelInsets = getTickLabelInsets();
        double result = tickLabelInsets.getLeft() + tickLabelInsets.getRight();

        Font tickLabelFont = getTickLabelFont();
        FontRenderContext frc = g2.getFontRenderContext();
        LineMetrics lm = tickLabelFont.getLineMetrics("ABCxyz", frc);
        if (isVerticalTickLabels()) {
            // all tick labels have the same width (equal to the height of
            // the font)...
            result += lm.getHeight();
        }
        else {
            // look at lower and upper bounds...
            DateRange range = (DateRange) getRange();
            Date lower = range.getLowerDate();
            Date upper = range.getUpperDate();
            String lowerStr, upperStr;
            DateFormat formatter = getDateFormatOverride();
            if (formatter != null) {
                lowerStr = formatter.format(lower);
                upperStr = formatter.format(upper);
            }
            else {
                lowerStr = unit.dateToString(lower);
                upperStr = unit.dateToString(upper);
            }
            FontMetrics fm = g2.getFontMetrics(tickLabelFont);
            double w1 = fm.stringWidth(lowerStr);
            double w2 = fm.stringWidth(upperStr);
            result += Math.max(w1, w2);
        }

        return result;
    }   

    @Override
    public AxisState draw(Graphics2D g2, double cursor, Rectangle2D plotArea, Rectangle2D dataArea, RectangleEdge edge,
            PlotRenderingInfo plotState) {

        double labelWidth = estimateMaximumTickLabelWidth(g2, getTickUnit());

        double lastLabelPosition = dateToJava2D(calculateHighestVisibleTickValue(getTickUnit()),
                plotArea, edge);

        if (lastLabelPosition + labelWidth / 2 > plotArea.getMaxX()) {
            double plottingWidthCorrection = plotArea.getX() + (lastLabelPosition + labelWidth / 2) - plotArea.getMaxX();

            // Calculate and set the new corrected maximum date
            setMaximumDate(new Date((long)(getMaximumDate().getTime() + java2DToValue(plottingWidthCorrection, plotArea, edge) - getMinimumDate().getTime())));
        }

        return super.draw(g2, cursor, plotArea, dataArea, edge, plotState);
    }
}