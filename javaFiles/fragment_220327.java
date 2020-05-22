import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author blj0011
 */
public class FXMLDocumentController implements Initializable {

//    @FXML
//    private NumberAxis xAxis;
//    @FXML
//    private NumberAxis yAxis;
    @FXML
    private AreaChart<Number, Number> areaChart;
    @FXML
    private TextField txtSt;
    @FXML
    private TextField txtEt;
    @FXML
    private TextField txtNb;


    ArrayList<XYChart.Series<Number, Number>> seriesContainer = new ArrayList();//Use an ArrayList to hold new Series!


        //Button add functionality
        @FXML
        private void generateGraph() {

            Double start = Double.parseDouble(txtSt.getText());

            Double end = Double.parseDouble(txtEt.getText());
            double numberEmployees = Integer.parseInt(txtNb.getText());

            XYChart.Series<Number, Number> series= new XYChart.Series<>();

            for (int i = start.intValue(); i <= end.intValue(); i++) {
                series.getData().add(new XYChart.Data(i, numberEmployees));
            }


           // Add Series to series container.
           seriesContainer.add(series);

           //Add only new series to AreaChart
           for(XYChart.Series<Number, Number> entry : seriesContainer)
           {
               if(!areaChart.getData().contains(entry))
               {                    
                    areaChart.getData().add(entry);
               }
           }
        }

        private void setOnMouseEventsOnSeries(Node node, 
                final AreaChart chart, final String label) {

            node.setOnMouseClicked(new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent t) {
                   chart.setTitle(label);
                }
            });

        }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        areaChart.setTitle("Chronos");
        areaChart.getXAxis().setLabel("Heures");
        areaChart.getYAxis().setLabel("Employés");
    }
}