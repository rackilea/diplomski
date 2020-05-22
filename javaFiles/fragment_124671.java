import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import org.jfree.chart.*;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.util.ShapeUtilities;

public class FreeChartDemo {

  XYSeriesCollection xySeriesCollection;
  String title;

  public FreeChartDemo(String title){
      this.title = title;
  }

  public void initGUI(){

      JButton clearChart =  new JButton("Clear chart");
      clearChart.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              xySeriesCollection.removeAllSeries();
          }
      });

      JButton fillChart = new JButton("Fill chart") ;
      fillChart.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              xySeriesCollection.removeAllSeries();
              fillChart();
          }
      });

      JPanel controlPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
      controlPanel.add(clearChart);
      controlPanel.add(fillChart);

      JPanel content = new JPanel(new BorderLayout(5, 5));
      content.add(getFreeChartPanel(), BorderLayout.CENTER); //add the ChartPanel here
      content.add(controlPanel, BorderLayout.SOUTH);

      JFrame frame = new JFrame("JFreeChart demo");
      frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      frame.getContentPane().add(content);
      frame.pack();
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
   }

   private JPanel getFreeChartPanel(){
       xySeriesCollection = new XYSeriesCollection();

       JFreeChart chart = ChartFactory.createScatterPlot(title, "X axis", "Y axis", xySeriesCollection, 
                                                         PlotOrientation.VERTICAL, true, true, false);       
       XYPlot plot = chart.getXYPlot();
       plot.setDomainCrosshairVisible(true);
       plot.setRangeCrosshairVisible(true);

       XYItemRenderer renderer = plot.getRenderer();
       renderer.setSeriesPaint(0, Color.magenta);
       renderer.setSeriesPaint(1, Color.green);
       renderer.setSeriesPaint(2, Color.blue);
       renderer.setSeriesPaint(4, Color.black);
       renderer.setSeriesPaint(3, Color.yellow);

       Shape cross = ShapeUtilities.createDiagonalCross(3, 0);

       for (int i = 0; i <= 3; i++) {
           renderer.setSeriesShape(0+i, new Rectangle(-1, -1, 2, 2));
           renderer.setSeriesShape(4+i, new Ellipse2D.Float(-2F, -2F, 5F, 5F));  
           renderer.setSeriesShape(8+i, cross);
       }

       NumberAxis domain = (NumberAxis) plot.getDomainAxis();
       domain.setRange(0,100);
       NumberAxis range = (NumberAxis) plot.getRangeAxis();
       range.setRange(0,120);

       return new ChartPanel(chart);
   }

   private void fillChart() {
       SwingWorker<Void, XYSeries> worker = new SwingWorker<Void, XYSeries>() {

           @Override
           protected Void doInBackground() throws Exception {
               int numberOfElements = 1000;    
               for(int y = 0; y < 12; y++) {
                   XYSeries series = new XYSeries("Plot " + y);
                   for (int x = 0; x < numberOfElements; x++) {
                       series.add(x, y*10); //add x,y point
                   }
                   publish(series);
                   Thread.sleep(100);// just for animation purpose
               }
               return null;              
           }

           @Override
           protected void process(List<XYSeries> chunks) {
               for(XYSeries series : chunks){
                   xySeriesCollection.addSeries(series);
               }
           }
       };
       worker.execute();
   }

   public static void main(String args[]) {
      SwingUtilities.invokeLater(new Runnable() {
         @Override
         public void run() {
             new FreeChartDemo("JFreeChart #1").initGUI();
             new FreeChartDemo("JFreeChart #2").initGUI();
         }
      });
   }
}