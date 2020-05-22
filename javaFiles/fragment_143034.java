import java.util.Random;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class StackedBarChartExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        StackedBarChart<String, Number> chart = new StackedBarChart<>(new CategoryAxis(), new NumberAxis());

        Random rng = new Random();

        int numSeries = 10 ;
        int defaultColorsDefined = 8 ;


        for (int i = 0; i < numSeries; i++) {
            Series<String, Number> series = new Series<>();
            Data<String, Number> untreated = new Data<>("Untreated", rng.nextDouble());
            series.getData().add(untreated);
            Data<String, Number> treated = new Data<>("Treated", rng.nextDouble());
            series.getData().add(treated);
            series.setName("Series "+i);

            chart.getData().add(series);

            // add style classes for additional series beyond the default support:
            // Note this must be done after adding the series to the chart...
            if (i >= defaultColorsDefined) {
                untreated.getNode().getStyleClass().add("default-color"+i);
                treated.getNode().getStyleClass().add("default-color"+i);
            }
        }

        BorderPane root = new BorderPane(chart);
        Scene scene = new Scene(root);
        scene.getStylesheets().add("stacked-bar-chart.css");
        primaryStage.setScene(scene);
        primaryStage.show();


    }

    public static void main(String[] args) {
        launch(args);
    }
}