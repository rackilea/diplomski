import java.awt.Color;
import java.awt.Font;
import java.text.DecimalFormat;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.fx.ChartViewer;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

/**
 * @see https://stackoverflow.com/a/55737893/230513
 * @see https://stackoverflow.com/q/44289920/230513
 */
public class PieChartFX extends Application {

    private static PieDataset createDataset() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("A", 0.8);
        dataset.setValue("B", 9.4);
        dataset.setValue("C", 0.1);
        dataset.setValue("D", 89.5);
        dataset.setValue("E", 0.2);
        dataset.setValue("F", 0.0);
        return dataset;
    }

    private static JFreeChart createChart(String name) {
        PieDataset dataset = createDataset();
        JFreeChart chart = ChartFactory.createPieChart(
            name, dataset, false, true, false);
        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setOutlineVisible(false);
        plot.setSectionPaint("A", Color.RED);
        plot.setSectionPaint("B", Color.BLUE);
        plot.setSectionPaint("C", Color.GREEN);
        plot.setSectionPaint("D", Color.YELLOW);
        plot.setSectionPaint("E", Color.CYAN);
        plot.setLabelFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
        // Custom labels https://stackoverflow.com/a/17507061/230513
        PieSectionLabelGenerator gen = new StandardPieSectionLabelGenerator(
            "{0}: {2}", new DecimalFormat("0"), new DecimalFormat("0.0%"));
        plot.setLabelGenerator(gen);
        return chart;
    }

    @Override
    public void start(Stage stage) {
        TabPane tabPane = new TabPane(
            new Tab("Tab 1", new ChartViewer(createChart("One"))),
            new Tab("Tab 2", new ChartViewer(createChart("Two"))),
            new Tab("Tab 3", new ChartViewer(createChart("Three")))
        );
        stage.setScene(new Scene(tabPane));
        stage.setTitle("JFreeChart: PieChartFX");
        stage.setWidth(600);
        stage.setHeight(400);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}