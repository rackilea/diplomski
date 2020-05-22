package test.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import test.Main;
import test.model.Exercise;

public class Controller {
    @FXML
    private TableView<Exercise> exerciseTable;
    @FXML
    private TableColumn<Exercise, String> exerciseColumn;

    private ObservableList<Exercise> activeSession = FXCollections.observableArrayList();

    private Main main;

    public Controller() {
    }

    @FXML
    public void initialize() {
        exerciseColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        activeSession.add(new Exercise("hrrykane"));
        exerciseTable.setItems(activeSession);
    }

    public void setMainApp(Main main) {
        this.main = main;
    }
}