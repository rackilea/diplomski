import java.util.Arrays;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.embed.swing.JFXPanel;
import javafx.scene.chart.Axis;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;


public class JFXPanelScatterChartNS<X,Y> extends JFXPanel {
    private ScatterChart<X,Y> chart ;

    private boolean withDragAndDrop = false ;

    private JFXPanelScatterChartNS(Axis<X> xAxis, Axis<Y> yAxis) {
        chart = new ScatterChart<>(xAxis, yAxis);
        Platform.runLater(() -> createScene(withDragAndDrop));
    }

    private void createScene(boolean withDragAndDrop) {
        // ...
    }

    public static JFXPanelScatterChartNS<String, String> createStringInstance(String[] xAxisCategories, String[] yAxisCategories) {
        Axis<String> xAxisCategory = new CategoryAxis(FXCollections.observableList(Arrays.asList(xAxisCategories))); 
        Axis<String> yAxisCategory = new CategoryAxis(FXCollections.observableList(Arrays.asList(yAxisCategories)));
        return new JFXPanelScatterChartNS<>(xAxisCategory, yAxisCategory);
    }

    public static JFXPanelScatterChartNS<String, Number> createStringNumberInstance(String[] xAxisCategories) {
        Axis<String> xAxisCategory = new CategoryAxis(FXCollections.observableList(Arrays.asList(xAxisCategories))); 
        return new JFXPanelScatterChartNS<String, Number>(xAxisCategory, new NumberAxis(0.0,10.0,1.0));
    }

    public static JFXPanelScatterChartNS<Number, String> createNumberStringInstance(String[] yAxisCategories) {
        Axis<String> yAxisCategory = new CategoryAxis(FXCollections.observableList(Arrays.asList(yAxisCategories))); 
        return new JFXPanelScatterChartNS<Number, String>(new NumberAxis(0.0,10.0,1.0), yAxisCategory);
    }

    public static JFXPanelScatterChartNS<Number, Number> createNumberInstance() {
        return new JFXPanelScatterChartNS<Number, Number>(new NumberAxis(0.0,10.0,1.0), new NumberAxis(0.0,10.0,1.0));        
    }

    public void addSeries(String idSeries, String nameSeries, final X xIni, final Y yIni){        
        final XYChart.Series<X,Y> newSeries;
        //Valido si el Id ya existe
        final boolean seriesExist = seriesMap.containsKey(idSeries);
        //si no existe el ID entonces creo la nueva serie
        if(!seriesExist){
            newSeries = new XYChart.Series<>();
            ObservableList<XYChart.Data<X, Y>> listaSerie;
            listaSerie = FXCollections.synchronizedObservableList(FXCollections.observableList(new ArrayList<XYChart.Data<X, Y>>()));
            newSeries.setData(listaSerie);
            newSeries.setName(nameSeries);
            newSeries.getData().add(new XYChart.Data<>(xIni,yIni));

            Platform.runLater(() -> {
                //Genero el index para la nueva serie
                Integer newIndex = new Integer(chart.getData().size());
                chart.getData().add(newIndex.intValue(), newSeries);

                seriesMap.put(idSeries, newIndex);
            });
        }
    }

    public void setData(final String idSeries, final int index, final X x, final Y y){
        //valido que exista la serie
        boolean seriesExist = seriesMap.containsKey(idSeries);
        //obtengo el index de la serie, como fue almacenada en la grafica
        Integer indexSerie =  seriesMap.get(idSeries);
        if(seriesExist){
            Platform.runLater(() -> {
                XYChart.Series<X,Y> currentSeries = null;
                currentSeries = chart.getData().get(indexSerie.intValue());
                currentSeries.getData().set(index,new XYChart.Data<>(x,y));
            });
        }
    }
}