import java.util.Random;

import javafx.application.Application;
import javafx.geometry.Bounds;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class LineChartWithTooltip extends Application {

    @Override
    public void start(Stage primaryStage) {
        LineChart<Number, Number> chart = new LineChart<>(new NumberAxis(), new NumberAxis());
        Series<Number, Number> series = new Series<>();
        series.setName("Data");
        Random rng = new Random();
        for (int i = 0 ; i <= 10; i++) {
            series.getData().add(new Data<>(i, rng.nextDouble()));
        }
        chart.getData().add(series);

        Tooltip tooltip = new Tooltip();
        for (Data<Number, Number> d : series.getData()) {
            d.getNode().setOnMouseEntered(event -> {
                tooltip.setText(String.format("[%d, %.3f]", d.getXValue().intValue(), d.getYValue().doubleValue()));
                Bounds nodeBounds = d.getNode().getBoundsInLocal();
                Bounds nodeBoundsInScreen = d.getNode().localToScreen(nodeBounds);
                tooltip.show(d.getNode(),
                        nodeBoundsInScreen.getMaxX()+15,
                        nodeBoundsInScreen.getMaxY()+5);
                    });
            d.getNode().setOnMouseExited(event -> tooltip.hide());
        }

        primaryStage.setScene(new Scene(new BorderPane(chart), 600, 600));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}