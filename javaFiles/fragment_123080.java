import java.util.Set;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class ScatterChartSample extends Application {

    @Override
    public void start(Stage stage) {
        NumberAxis xAxis = new NumberAxis(1960, 2020, 10);
        xAxis.setLabel("Years");

        NumberAxis yAxis = new NumberAxis(0, 350, 50);
        yAxis.setLabel("No.of schools");

        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Chart");

        XYChart.Series<Number, Number> series = new XYChart.Series<>();
        series.setName("No of schools in an year");
        Platform.runLater(()
                -> {

            Set<Node> nodes = lineChart.lookupAll(".series" + 0);
            for (Node n : nodes) {
                n.setStyle("-fx-background-color: black, white;\n"
                        + "    -fx-background-insets: 0, 2;\n"
                        + "    -fx-background-radius: 5px;\n"
                        + "    -fx-padding: 5px;");
            }

            series.getNode().lookup(".chart-series-line").setStyle("-fx-stroke: black;");
        });

        series.getData().add(new XYChart.Data<>(1970, 15));
        series.getData().add(new XYChart.Data<>(1980, 30));
        series.getData().add(new XYChart.Data<>(1990, 60));
        series.getData().add(new XYChart.Data<>(2000, 120));
        series.getData().add(new XYChart.Data<>(2013, 240));
        series.getData().add(new XYChart.Data<>(2014, 300));

        lineChart.getData().add(series);

        var scene = new Scene(lineChart);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}