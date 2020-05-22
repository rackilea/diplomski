@Override
public void start(Stage primaryStage) {
    PieChart pieChart = new PieChart();
    pieChart.setData(getPieData());
    final HashMap<String, Integer> colors = new HashMap<>();
    pieChart.getData().stream().forEach((pd)->{
        colors.put(pd.getName(), pieChart.getData().indexOf(pd));
    });

    final CategoryAxis xAxis = new CategoryAxis(FXCollections.observableArrayList("none"));
    final NumberAxis yAxis = new NumberAxis();
    final StackedBarChart<String, Number> sbc =
            new StackedBarChart<>(xAxis, yAxis);
    ObservableList<Series<String, Number>> barData = createBarData(getPieData());
    // simulate client code that re-orders/filters the data
    FXCollections.shuffle(barData);
    sbc.setData(barData);

    primaryStage.setTitle("Correlated Charts");
    Scene scene = new Scene(new HBox(pieChart, sbc));
    primaryStage.setScene(scene);
    primaryStage.show();

    //can only get nodes after charts are drawn
    barData.stream().forEach((bd)->{
        int num = colors.get(bd.getName());
        //eg. chart-bar series1 data0 default-color1
        bd.getData().get(0).getNode().getStyleClass().setAll("chart-bar","series"+num,"data0","default-color"+num);
    });

    Legend legend = (Legend)sbc.lookup(".chart-legend");
    legend.getChildrenUnmodifiable().stream().forEach((l)->{
        Label label = (Label)l;
        Node n = label.getGraphic();
        int num = colors.get(label.getText());
        //eg. chart-legend-item-symbol chart-bar series1 bar-legend-symbol default-color1
        n.getStyleClass().setAll("chart-legend-item-symbol","chart-bar","series"+num,"bar-legend-symbol","default-color"+num);
    });
}