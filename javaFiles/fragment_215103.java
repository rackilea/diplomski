package yourpackage;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class FileList extends VBox {

    private Model model; // NOT REALLY NEEDED! KEEPING IT BECAUSE YOUR FileListController HAD IT TOO...

    @FXML
    Label label_rootFolder;

    public FileList() {
        java.net.URL url = getClass().getResource("/yourpackage/FileList.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader(url);
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        }
        catch( IOException e ) {
            throw new RuntimeException(e);
        }
    }

    public void setModel(Model model) {
        label_rootFolder.textProperty().unbind();
        this.model = model; // NOT REALLY NEEDED!
        label_rootFolder.textProperty().bind(model.rootFolderProperty());
    }
}