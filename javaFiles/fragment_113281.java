import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.chart.XYChart.Series;
import javafx.stage.Stage;

public class ScatterPlotTest extends Application {

    @Override
    public void start(Stage primaryStage) {
        ScatterPlotWithBestFitLine plot = new ScatterPlotWithBestFitLine(new NumberAxis(), new NumberAxis());

        plot.getData().add(createSeries("Data", new double[] {
                {10,15},
                {15,20},
                {77,77},
                {55,13},
                {44,22},
                {45,43}
        }));


        Scene scene = new Scene(plot, 600, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Series<Number, Number> createSeries(String name, double[][] values) {
        Series<Number, Number> series = new Series<>();
        series.setName("Data");
        for (double[] point : values) {
            series.getData().add(new Data<>(point[0],point[1]));
        }
        return series ;
    }            

    public static void main(String[] args) {
        launch(args);
    }
}