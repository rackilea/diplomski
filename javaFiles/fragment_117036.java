package doughnut;

import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;

public class SampleController {
    @FXML
    private PieChart doughnutChart ;

    public void initialize() {
        doughnutChart.getData().addAll(
            new PieChart.Data("Grapefruit", 13),
            new PieChart.Data("Oranges", 25),
            new PieChart.Data("Plums", 10),
            new PieChart.Data("Pears", 22),
            new PieChart.Data("Apples", 30));

    }
}