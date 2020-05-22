import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.transform.Affine;
import javafx.scene.transform.Transform;
import javafx.stage.Stage;
import javafx.util.Duration;

public class TestCustomLayoutUpdate extends Application {

    private LineChart<Number, Number> chart;
    private NumberAxis xAxis;
    private NumberAxis yAxis;


    private ObjectProperty<ShopItem> currentShopItem;

    class ShopItem {
        private double price;

        public ShopItem(double price) {
            this.price = price;
        }
    }

    @Override
    public void start(Stage primaryStage) {

        currentShopItem = new SimpleObjectProperty<>();


        createChart();

        Scene scene = new Scene(chart, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.setHeight(600);
        primaryStage.setWidth(400);
        primaryStage.show();

        Random rng = new Random();

        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1),  
                evt -> currentShopItem.set(new ShopItem(rng.nextDouble() * 100))
        ));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    public void createChart() {
        xAxis = new NumberAxis();
        yAxis = new NumberAxis();
        xAxis.setAutoRanging(false);
        xAxis.setUpperBound(100);

        chart = new LineChart<Number, Number>(xAxis, yAxis) {

            private List<Shape> shapes = new ArrayList<>();

            private Rectangle rect ;

            // anonymous class constructor:
            {
                rect = new Rectangle(0,0, Color.RED);

                currentShopItem.addListener((obs, oldItem, newItem) -> {
                    if (newItem == null) {
                        rect.setWidth(0);
                        rect.setHeight(0);
                    } else {
                        rect.setWidth(10);
                        rect.setHeight(newItem.price);
                    }

                });
            }

            @Override
            public void layoutPlotChildren() {
                super.layoutPlotChildren();

                getPlotChildren().removeAll(shapes);
                shapes.clear();

                if (currentShopItem != null) {
                    rect.getTransforms().setAll(chartDisplayTransform(xAxis, yAxis));
                    shapes.add(rect);
                    getPlotChildren().addAll(shapes);
                }
            }
        };
    }

    private Transform chartDisplayTransform(NumberAxis xAxis, NumberAxis yAxis) {
        return new Affine(xAxis.getScale(), 0, xAxis.getDisplayPosition(0), 0, yAxis.getScale(),
                yAxis.getDisplayPosition(0));
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}