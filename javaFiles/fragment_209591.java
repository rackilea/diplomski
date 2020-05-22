import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;


public class LineChartJavaFXTest extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Line Chart Sample");
        //defining the axes
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Seconds");
        yAxis.setLabel("Volume");


        //defining a series
        XYChart.Series series = new XYChart.Series();
        //populating the series with data

        series.getData().add(new XYChart.Data(1, 0));
        series.getData().add(new XYChart.Data(2, 1));
        series.getData().add(new XYChart.Data(3, 2));
        series.getData().add(new XYChart.Data(4, 2));
        series.getData().add(new XYChart.Data(5, 1));
        series.getData().add(new XYChart.Data(6, 2));
        series.getData().add(new XYChart.Data(7, 3));
        series.getData().add(new XYChart.Data(8, 3));
        series.getData().add(new XYChart.Data(9, 4));
        series.getData().add(new XYChart.Data(10, 3));
        series.getData().add(new XYChart.Data(11, 2));
        series.getData().add(new XYChart.Data(12, 1));


        //creating the chart
        final LineChart<Number, Number> lineChart = 
             new LineChart<Number, Number>(xAxis, yAxis, FXCollections.observableArrayList(series)) {
            @Override
            protected void layoutPlotChildren() {
                super.layoutPlotChildren();
                Series series =  (Series) getData().get(0);
                ObservableList<Data<Number,Number>> listOfData = series.getData();

                for(int i = 0; i < listOfData.size()-1; i++) {
                    // Check for Y value >=3
                    if(listOfData.get(i).getYValue().doubleValue() >= 3 &&
                            listOfData.get(i+1).getYValue().doubleValue() >= 3) {
                        double x1 = getXAxis().getDisplayPosition(listOfData.get(i).getXValue());
                        double y1 = getYAxis().getDisplayPosition(0);
                        double x2 = getXAxis().getDisplayPosition(listOfData.get((i + 1)).getXValue());
                        double y2 = getYAxis().getDisplayPosition(0);
                        Polygon polygon = new Polygon();
                        LinearGradient linearGrad = new LinearGradient( 0, 0, 0, 1,
                                true, // proportional
                                CycleMethod.NO_CYCLE, // cycle colors
                                new Stop(0.1f, Color.rgb(255, 0, 0, .3)));

                        polygon.getPoints().addAll(new Double[]{
                                x1,y1,
                                x1, getYAxis().getDisplayPosition(listOfData.get(i).getYValue()),
                                x2,getYAxis().getDisplayPosition(listOfData.get((i+1)).getYValue()),
                                x2,y2
                        });
                        getPlotChildren().add(polygon);
                        polygon.toFront();
                        polygon.setFill(linearGrad);
                    }
                }
            }
        };

        lineChart.setTitle("Test Chart");

        Scene scene = new Scene(lineChart, 800, 600);
        scene.getStylesheets().add("LineChart.css");
        lineChart.applyCss();

        stage.setScene(scene);
        stage.show();
    }
}