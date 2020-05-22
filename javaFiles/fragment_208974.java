import javafx.fxml.FXML;
import javafx.geometry.Point2D;
import javafx.scene.layout.StackPane;

public class GUI2Controller{

    @FXML StackPane root;
    private Point2D[] events;
    private SimpleHeatMap heatMap;

    @FXML
    public void initialize() {

        //initialize here all info that you want to retrieve later
        heatMap = new SimpleHeatMap(400, 400, ColorMapping.LIME_YELLOW_RED, 40);
        events  = new Point2D[] {
                new Point2D(110, 238),
                new Point2D(120, 144),
                new Point2D(207, 119),
                new Point2D(315, 348),
                new Point2D(264, 226),
                new Point2D(280, 159),
                new Point2D(240, 186),
                new Point2D(228, 170),
                new Point2D(234, 160),
                new Point2D(214, 170),
                new Point2D(200, 200),
        };

        //you could also populate root
        //root.getChildren().setAll(heatMap.getHeatMapImage());
    }

    public SimpleHeatMap getHeatMap() {
        return heatMap;
    }

    public  Point2D[] getEvents() {
        return events;
    }
}