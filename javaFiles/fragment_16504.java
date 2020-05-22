import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application
{

    @Override
    public void start(Stage primaryStage)
    {
        BorderPane pane = new BorderPane();

        PieChart chart = new PieChart();

        Button randomValues = new Button();
        randomValues.setOnAction(ae -> {
            chart.getData().clear();

            List<PieChart.Data> data = randomValues().stream().map(i -> new PieChart.Data("Test" + i % 10, i)).collect(Collectors.toList());
            chart.getData().addAll(data);
            data.forEach(d -> {
                Tooltip tip = new Tooltip();
                tip.setText(d.getPieValue() + "");
                Tooltip.install(d.getNode(), tip);
            });

        });

        pane.setCenter(chart);
        pane.setBottom(randomValues);
        primaryStage.setScene(new Scene(pane));
        primaryStage.show();
    }

    private List<Integer> randomValues()
    {
        return new Random().ints(5).boxed().collect(Collectors.toList());
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}