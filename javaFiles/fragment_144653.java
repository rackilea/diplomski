import java.awt.Color;
import java.awt.Dimension;
import java.awt.Paint;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.axis.SymbolAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;


public class BarChartDemo7 extends ApplicationFrame {

    static class CustomRenderer extends BarRenderer {

        private final Paint[] colors1;
        private final Paint[] colors2;

        public CustomRenderer(Paint[] colors1,Paint[] colors2) {
            this.colors1 = colors1;
            this.colors2 = colors2;
        }

        @Override
        public Paint getItemPaint(int series, int category) {
            if (category == 4)
                return this.colors2[series % this.colors1.length];
            else
                return this.colors1[series % this.colors1.length];
        }
    }


    public BarChartDemo7(String title) {
        super(title);
        CategoryDataset dataSet=createDataset();
        JFreeChart chart=createChart(dataSet);
        ChartPanel panel=new ChartPanel(chart);
        panel.setPreferredSize(new Dimension(800,800));
        setContentPane(panel);
    }


    private static CategoryDataset createDataset() {
        // row keys...
        final String series1 = "ABC";
        final String series2 = "XYZ";

        // column keys...
        final String category1 = "A";
        final String category2 = "B";
        final String category3 = "C";
        final String category4 = "D";
        final String category5 = "E";
        final String category6 = "F";

        // create the dataset...
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        dataset.addValue(35, series1, category1);
        dataset.addValue(37, series1, category2);
        dataset.addValue(40, series1, category3);
        dataset.addValue(52, series1, category4);
        dataset.addValue(52, series1, category5);
        dataset.addValue(52, series1, category6);


        dataset.addValue(30, series2, category1);
        dataset.addValue(32, series2, category2);
        dataset.addValue(35, series2, category3);
        dataset.addValue(45, series2, category4);
        dataset.addValue(30, series2, category1);
        dataset.addValue(32, series2, category2);
        dataset.addValue(35, series2, category5);
        dataset.addValue(45, series2, category4);

        return dataset;
    }



    private static JFreeChart createChart(CategoryDataset dataset) {

        // create the chart...
        JFreeChart chart = ChartFactory.createBarChart(
            "ABC",             
            "",                      
            "",                         
            dataset,                         
            PlotOrientation.VERTICAL,        
            true,                            
            true,                            
            false                            
        );

        chart.setBackgroundPaint(Color.white);

        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        plot.setBackgroundPaint(Color.WHITE);
        plot.setDomainGridlinePaint(Color.BLACK);
        plot.setRangeGridlinePaint(Color.BLACK);

        //Provide a new Symbol Axis
        String[] grade =  new String[101];
        for (int i = 0 ; i < grade.length ; i ++){
            grade[i] = Integer.toString(i);
        }
        grade[0] = "Poor    0";
        grade[50] = "Avg.   50";
        grade[100] = "Best   100";
        SymbolAxis rangeAxis = new SymbolAxis("", grade);
        rangeAxis.setTickUnit(new NumberTickUnit(10));
        rangeAxis.setAutoRange(false);
        rangeAxis.setRange(0, 100);
        plot.setRangeAxis(rangeAxis);


        Color[] color1 = new Color[]{Color.red, Color.green,Color.blue};
        Color[] color2 = new Color[]{Color.gray,Color.gray.darker()};
        plot.setRenderer(new CustomRenderer(color1,color2));
        return chart;
    }

    public static void main(String[] args) {
        BarChartDemo7 demo = new BarChartDemo7("ABC");
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);
    }
}