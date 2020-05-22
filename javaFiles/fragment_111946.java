public class Main extends Application {

private Stage window;
private double chartMaxX;
private double chartMinX;
private double chartMaxY;
private double chartMinY;

@Override
public void start(Stage primaryStage) {
    try {

        window = primaryStage;

        NumberAxis xAxis = new NumberAxis();
        NumberAxis yAxis = new NumberAxis();

        xAxis.setAutoRanging(false); //prevent automatic resizing for simplicity
        yAxis.setAutoRanging(false); //prevent automatic resizing for simplicity


        chartMaxX = 250.0;
        chartMinX = 0.0;

        chartMaxY = 300.0;
        chartMinY = 0.0;

        /*
         * ranges of Axis are preset for simplicity, but could be altered without much trouble
         */

        xAxis.setUpperBound(chartMaxX);
        xAxis.setLowerBound(chartMinX);

        yAxis.setUpperBound(chartMaxY);
        yAxis.setLowerBound(chartMinY);

        LineChart<Number,Number> contrastChart = new LineChart<>(xAxis,yAxis);
        XYChart.Series<Number, Number> series = new XYChart.Series<>();
        series.setName("ContrastValues");
        //populating the series with data
        Data<Number, Number> d0 = new Data<Number, Number>(10, 10);
        Data<Number, Number> d1 = new Data<Number, Number>(75, 75);
        Data<Number, Number> d2 = new Data<Number, Number>(150, 150);
        Data<Number, Number> d3 = new Data<Number, Number>(240, 240);

        series.getData().add(d0);
        series.getData().add(d1);
        series.getData().add(d2);
        series.getData().add(d3);

        contrastChart.setLegendVisible(true);
        contrastChart.getData().add(series);

        contrastChart.setAnimated(false); //prevent animations, as they will pull the point out of sync with the cursor.

        for(Data<Number, Number> point: series.getData()) {
            point.getNode().setOnMouseDragged(event -> {

                Point2D translateXY = point.getNode().screenToLocal(event.getScreenX(), event.getScreenY());

                point.setXValue(translateXY.getX()+point.getXValue().doubleValue());
                point.setYValue(reverseNumberInRange(translateXY.getY()+(chartMaxY-point.getYValue().doubleValue()), chartMinY, chartMaxY));
            });
        }

        //SCENE
        Scene myScene = new Scene(contrastChart, chartMaxY, chartMaxX);
        window.setScene(myScene);
        window.show();

    } catch(Exception e) {
        e.printStackTrace();
    }
}

public static void main(String[] args) {
    launch(args);
}

public double reverseNumberInRange(double value, double minVal, double maxVal) {
    /*
     * y0 is top left on screen, and bottom left in chart, need to reverse.
     */
    return (maxVal + minVal) - value;
}