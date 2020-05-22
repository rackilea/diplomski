import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import java.io.IOException;

public class MainController {

    @FXML
    private AnchorPane paneMainContent;
    @FXML
    private VBox vboxShowCats;
    @FXML
    private Button btnShowCats;
    @FXML
    private VBox vboxShowDogs;
    @FXML
    private Button btnShowDogs;
    @FXML
    private VBox vboxShowBirds;
    @FXML
    private Button btnShowBirds;

    @FXML
    private void initialize() {

        btnShowCats.setOnAction(event -> loadPage("Cats"));
        btnShowDogs.setOnAction(event -> loadPage("Dogs"));
        btnShowBirds.setOnAction(event -> loadPage("Birds"));

    }

    private void loadPage(String name) {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(name + "View.fxml"));

            AnchorPane newPane = loader.load();

            // Set the loaded FXML file as the content of our main right-side pane
            paneMainContent.getChildren().setAll(newPane);

            // Reset the anchors
            AnchorPane.setBottomAnchor(newPane, 0.0);
            AnchorPane.setLeftAnchor(newPane, 0.0);
            AnchorPane.setRightAnchor(newPane, 0.0);
            AnchorPane.setTopAnchor(newPane, 0.0);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}