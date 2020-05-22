public class CustomPieChart extends PieChart {
    public CustomPieChart(ObservableList<PieChart.Data> data){
        super(data);
        setLabelLineLength(20);
        createScrollableLegend();
        setLegendSide(Side.RIGHT);
        setClockwise(true);
    }

    private void createScrollableLegend(){
        Legend legend = (Legend) getLegend();
        if(legend != null){
            legend.setPrefWidth(100);
            ScrollPane scrollPane = new ScrollPane(legend);
            scrollPane.setHbarPolicy(ScrollBarPolicy.NEVER);
            scrollPane.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);
            scrollPane.maxHeightProperty().bind(heightProperty());
            setLegend(scrollPane);
        }
    }
}