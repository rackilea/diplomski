import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    private ObservableList<PieChart.Data> createChartData() {
        return FXCollections.observableArrayList(
                new PieChart.Data("Post-production age", 424236),
                new PieChart.Data("Production age", 1030060),
                new PieChart.Data("Production age2", 1030060),
                new PieChart.Data("Production age3", 1030060),
                new PieChart.Data("Pre-production age", 310319)
        );
    }

    @Override
    public void start(Stage primaryStage) {
        PieChart chart = new PieChart(createChartData());
        chart.setStartAngle(90.0);

        Button rotateBtn = new Button("Rotate");
        rotateBtn.setOnAction(event -> {
            event.consume();
            PieChart.Data removed = chart.getData().remove(chart.getData().size() - 1);
            chart.getData().add(0, new PieChart.Data(removed.getName(), removed.getPieValue()));
        });

        VBox root = new VBox(10, rotateBtn, new Separator(), chart);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20));

        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

}