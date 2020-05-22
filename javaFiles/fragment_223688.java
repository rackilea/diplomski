import java.text.NumberFormat;

import net.sf.jasperreports.engine.JRChart;
import net.sf.jasperreports.engine.JRChartCustomizer;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.AbstractCategoryItemLabelGenerator;
import org.jfree.chart.labels.CategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.CategoryDataset;


public class SimpleBarChartCustomizer implements JRChartCustomizer {

    public void customize(JFreeChart chart, JRChart jasperChart) {
        CategoryPlot plot = chart.getCategoryPlot();
        BarRenderer renderer = (BarRenderer) plot.getRenderer();

        CategoryItemRenderer catRenderer = ((CategoryItemRenderer)renderer);
        catRenderer.setBaseItemLabelGenerator(new NumberLabelGenerator("", NumberFormat.getInstance()));

    }

    static class NumberLabelGenerator extends AbstractCategoryItemLabelGenerator implements CategoryItemLabelGenerator {
        public NumberLabelGenerator(String labelFormat,
                NumberFormat formatter, NumberFormat percentFormatter) {
            super(labelFormat, formatter, percentFormatter);
        }

        protected NumberLabelGenerator(String labelFormat,  NumberFormat formatter) {
            super(labelFormat, formatter);
        }

        private NumberFormat formatter = NumberFormat.getInstance();

        public String generateLabel(CategoryDataset dataset, int series, int category) {
            Number b = dataset.getValue(series, category);
            formatter.setMaximumFractionDigits(2);
            return formatter.format(b);
        }

    }
}