import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Test extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Application.launch(Test.class, args);
    }

    @Override
    public void start(final Stage primaryStage) {
        primaryStage.setTitle("Hello World");
        Group root = new Group();
        Scene scene = new Scene(root, 300, 250, Color.LIGHTGREEN);
        Button btn = new Button();
        btn.setLayoutX(100);
        btn.setLayoutY(80);
        btn.setText("Create stage");
        btn.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                CreateStage();
                primaryStage.toFront();

            }
        });
        root.getChildren().add(btn);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void CreateStage() {

        Stage stage = new Stage();
        stage.setTitle("Line Chart Sample");
        //Basic Chart attributes
        NumberAxis xAxis = new NumberAxis();
        NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("RT [minutes]");
        yAxis.setLabel("Intensity");

        //linechart.getData().clear();
        LineChart<Number, Number> linechart = new LineChart(xAxis, yAxis);

        XYChart.Series newSeries = new XYChart.Series();

        List<XYChart.Data> list = new ArrayList<>();
        //just fill the chart with data points
        for (int j = 0; j < 10000; j++) {
            float intensity = j;
            float currentRT = j;

            list.add(new XYChart.Data(currentRT, intensity));
        }
        newSeries.getData().addAll(list);

        // add new Series
        linechart.getData().add(newSeries);

        Scene scene = new Scene(linechart, 800, 600);

        stage.setScene(scene);
        stage.show();

        //this fixes it
        stage.setOnCloseRequest(event -> {
            for (XYChart.Series series : linechart.getData()) {
                series.getData().clear();
            }

        });

    }
}