import java.util.Random;
import java.util.stream.Stream;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ScatterQuadrantChartTest extends Application {

    @Override
    public void start(Stage primaryStage) {

        final Random rng = new Random();

        ScatterQuadrantChart<Number, Number> chart = new ScatterQuadrantChart<>(new NumberAxis(), new NumberAxis());
        Series<Number, Number> series = new Series<>();
        for (int i=0; i<20; i++) {
            series.getData().add(new Data<>(rng.nextDouble() * 100, rng.nextDouble() * 100));
        }
        chart.getData().add(series);

        chart.setXQuadrantDivider(50);
        chart.setYQuadrantDivider(50);

        BorderPane root = new BorderPane(chart);
        Scene scene = new Scene(root, 600, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}