import javafx.application.Application;
import javafx.beans.binding.ObjectExpression;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        var chart = new LineChart<>(new NumberAxis(), new NumberAxis());
        chart.getData().add(new Series<>(createData()));

        primaryStage.setScene(new Scene(chart, 600, 400));
        primaryStage.show();
    }

    private static ObservableList<Data<Number, Number>> createData() {
        var list = FXCollections.<Data<Number, Number>>observableArrayList();
        for (int x = 0; x < 10; x++) {
            var data = new Data<Number, Number>(x, Math.pow(x, 2));
            data.setNode(createDataNode(data.YValueProperty()));
            list.add(data);
        }
        return list;
    }

    private static Node createDataNode(ObjectExpression<Number> value) {
        var label = new Label();
        label.textProperty().bind(value.asString("%,.2f"));

        var pane = new Pane(label);
        pane.setShape(new Circle(6.0));
        pane.setScaleShape(false);

        label.translateYProperty().bind(label.heightProperty().divide(-1.5));

        return pane;
    }

}