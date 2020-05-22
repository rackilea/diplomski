public class StatisticsController {

    @FXML
    private BarChart<String, Number> barChartHistogram;

    private SortedMap<String, Integer> _points;

    @FXML
    private CategoryAxis xAxis ;
    @FXML
    private NumberAxis yAxis ;


    @FXML
    private void buttonShowPressed(ActionEvent event) {
        xAxis.setLabel("Numer indeksu");
        yAxis.setLabel("Ilość punktów");
        barChartHistogram.setCategoryGap(0);
        barChartHistogram.setBarGap(0);
        barChartHistogram.setTitle("XDDDDDDDDDDDDDDD");
        barChartHistogram.setMaxHeight(1000);
        XYChart.Series series = new XYChart.Series();
        series.setName("Histogram");
        for (Map.Entry<String, Integer> p: _points.entrySet()) {
            series.getData().add(new XYChart.Data(p.getKey(), p.getValue()));
        }
        barChartHistogram.getData().addAll(series);
    }
}