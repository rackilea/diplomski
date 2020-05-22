import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class JavaFXApplication28 extends Application {

    @Override
    public void start(Stage stage) {

        stage.setTitle("Imported Fruits");
        stage.setWidth(500);
        stage.setHeight(500);

        LabeledPieChart chart = new LabeledPieChart();
        chart.setTitle("Imported Fruits");

        // Add some data
        addPieChartData(chart, "Grapefruit", 13);
        addPieChartData(chart, "Oranges", 25);
        addPieChartData(chart, "Plums", 10);
        addPieChartData(chart, "Pears", 22);
        addPieChartData(chart, "Apples", 30);

        AnchorPane anchor = new AnchorPane();
        Scene scene = new Scene(anchor);
        anchor.getChildren().add(chart);

        AnchorPane.setBottomAnchor(chart, 0.0);
        AnchorPane.setTopAnchor(chart, 0.0);
        AnchorPane.setLeftAnchor(chart, 0.0);
        AnchorPane.setRightAnchor(chart, 0.0);

        stage.setScene(scene);
        stage.show();
    }

    public void addPieChartData(LabeledPieChart pChart, String name, double value) {
        final Data data = new Data(name, value);
        pChart.getData().add(data);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}