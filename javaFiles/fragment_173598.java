import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

public abstract class SceneFactory {
    private static final String AUSTRIA = "Austria";
    private static final String BRAZIL = "Brazil";
    private static final String FRANCE = "France";
    private static final String ITALY = "Italy";
    private static final String USA = "USA";

    public static Scene getBarChartScene() {
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        final BarChart<String,Number> bc = new BarChart<String,Number>(xAxis,yAxis);
        bc.setTitle("Country Summary");
        xAxis.setLabel("Country");     
        yAxis.setLabel("Value");

        XYChart.Series series1 = new XYChart.Series();
        series1.setName("2003");       
        series1.getData().add(new XYChart.Data(AUSTRIA, 25601.34));
        series1.getData().add(new XYChart.Data(BRAZIL, 20148.82));
        series1.getData().add(new XYChart.Data(FRANCE, 10000));
        series1.getData().add(new XYChart.Data(ITALY, 35407.15));
        series1.getData().add(new XYChart.Data(USA, 12000));      

        XYChart.Series series2 = new XYChart.Series();
        series2.setName("2004");
        series2.getData().add(new XYChart.Data(AUSTRIA, 57401.85));
        series2.getData().add(new XYChart.Data(BRAZIL, 41941.19));
        series2.getData().add(new XYChart.Data(FRANCE, 45263.37));
        series2.getData().add(new XYChart.Data(ITALY, 117320.16));
        series2.getData().add(new XYChart.Data(USA, 14845.27));  

        XYChart.Series series3 = new XYChart.Series();
        series3.setName("2005");
        series3.getData().add(new XYChart.Data(AUSTRIA, 45000.65));
        series3.getData().add(new XYChart.Data(BRAZIL, 44835.76));
        series3.getData().add(new XYChart.Data(FRANCE, 18722.18));
        series3.getData().add(new XYChart.Data(ITALY, 17557.31));
        series3.getData().add(new XYChart.Data(USA, 92633.68));  

        Scene scene  = new Scene(bc,800,600);
        bc.getData().addAll(series1, series2, series3);
        return scene;
    }
}