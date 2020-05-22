import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class Controller {

  @FXML 
  private GridPane topGrid;

  @FXML
  private void handleAction(ActionEvent event) {
    topGrid.add(new ImageView(/*image*/), 0, 0);
    event.consume();
  }

}