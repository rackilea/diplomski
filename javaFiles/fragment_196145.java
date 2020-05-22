import java.util.ArrayList;
import java.util.List;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Side;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import javafx.util.Duration;

public class ChartContent extends StackPane {

    private LineChart<Number, Number> chart;
    private NumberAxis xAxis;
    private NumberAxis yAxis;
    private Series<Number, Number> series = new Series<Number, Number>();
    private int level = 0;
    private int datas[][] = { { 15, 8, 12, 11, 16, 21, 13 },
            { 10, 24, 20, 16, 31, 25, 44 }, { 88, 60, 105, 75, 151, 121, 137 },
            { 1000, 1341, 1211, 1562, 1400, 1600, 1550 }

    };

    public ChartContent() {

        xAxis = new NumberAxis();
        yAxis = new NumberAxis();

        yAxis.setSide(Side.RIGHT);
        yAxis.setForceZeroInRange(false);

        xAxis.setForceZeroInRange(false);

        chart = new LineChart<Number, Number>(xAxis, yAxis) {

            private List<Shape> shapes = new ArrayList<>();

            @Override
            public void layoutPlotChildren() {
                super.layoutPlotChildren();
                getPlotChildren().removeAll(shapes);
                shapes.clear();
                for (Data<Number, Number> d : series.getData()) {
                    double x = xAxis.getDisplayPosition(d.getXValue());
                    double y = yAxis.getDisplayPosition(d.getYValue());
                    shapes.add(new Circle(x, y, 3, Color.RED));
                }
                getPlotChildren().addAll(shapes);
            }
        };
        chart.setCreateSymbols(false);
        chart.setLegendVisible(false);
        chart.setAnimated(false);
        chart.setVerticalZeroLineVisible(false);

        Timeline timer = new Timeline(new KeyFrame(Duration.seconds(5),
                new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent event) {

                        chartRefresh();
                    }
                }));
        timer.setCycleCount(datas.length - 1);
        timer.play();

        getChildren().addAll(chart);
        chartRefresh();
    }

    private void chartRefresh() {

        series.getData().clear();
        if (level < datas.length) {

            for (int i = 0; i < datas[level].length; i++) {
                Data<Number, Number> data = new Data<Number, Number>(i, datas[level][i]);
                data.setNode(new Circle(3, Color.RED));
                series.getData().add(data);
            }
        }
        level++;

        chart.getData().clear();
        chart.getData().add(series);
        series.getNode().setStyle("-fx-stroke:blue;-fx-stroke-width:1");

    }


}