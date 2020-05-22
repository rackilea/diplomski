import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MultiAxisChart extends Application {

    @Override
    public void start(final Stage primaryStage) throws Exception {
        final StackPane chartStack = createChartStack();

        final Scene scene = new Scene(chartStack, 1600, 400, true);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private StackPane createChartStack() {
        LineChart<Number, Number> bottomChart = createChart();
        LineChart<Number, Number> topChart    = createChart();

        bottomChart.getYAxis().translateXProperty().bind(
                bottomChart.getXAxis().widthProperty().multiply(1.0/3)
        );
        topChart.getYAxis().translateXProperty().bind(
                topChart.getXAxis().widthProperty().multiply(2.0/3)
        );

        bottomChart.getYAxis().setTranslateZ(-1);
        topChart.getYAxis().setTranslateZ(-1);

        topChart.getStylesheets().addAll(getClass().getResource(
                "overlay-chart.css"
        ).toExternalForm());

        return new StackPane(bottomChart, topChart);
    }

    private LineChart<Number, Number> createChart() {
        NumberAxis xAxis = new NumberAxis(0, 300, 20);
        xAxis.setAutoRanging(false);
        xAxis.setAnimated(false);
        xAxis.setMinorTickVisible(false);
        xAxis.setTickLabelsVisible(false);
        xAxis.setTickMarkVisible(false);

        NumberAxis yAxis = new NumberAxis(30, 240, 30);
        yAxis.setAutoRanging(false);
        yAxis.setAnimated(false);
        yAxis.setTickMarkVisible(false);
        yAxis.setMinorTickVisible(false);
        yAxis.setMinorTickCount(3);

        final LineChart<Number, Number> ctg = new LineChart<>(xAxis, yAxis);

        ctg.setAnimated(false);
        ctg.setCreateSymbols(false);
        ctg.setAlternativeRowFillVisible(false);
        ctg.setLegendVisible(false);
        ctg.setHorizontalGridLinesVisible(true);
        ctg.setVerticalGridLinesVisible(true);

        return ctg;
    }

    public static void main(final String[] args) {
        launch(args);
    }
}