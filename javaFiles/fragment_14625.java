import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.stage.Stage;

public class MainController {

    @FXML
    private TableColumn<Void, Void> nameColumn ;
    @FXML
    private TableColumn<Void, Void> optionalColumn ;

    @FXML
    private void showViewOptions() throws IOException {
        FXMLLoader loader = new FXMLLoader(ViewOptionsController.class.getResource("ViewOptions.fxml"));
        Parent root = loader.load();
        ViewOptionsController controller = loader.getController();
        controller.setOptionalColumnVisible(optionalColumn.isVisible());
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.initOwner(nameColumn.getTableView().getScene().getWindow());
        stage.setOnHidden(e -> {
            refreshTable(controller.isOptionalColumnVisible());
        });
        stage.show();
    }

    private void refreshTable(boolean showOptionalColumn) {
        optionalColumn.setVisible(showOptionalColumn);
    }
}