import javafx.application.Application;
import javafx.collections.*;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class TableViewSample extends Application {

    private TableView<IdentifiedName> table = new TableView<>();
    private final ObservableList<IdentifiedName> data =
        FXCollections.observableArrayList(
            new IdentifiedName(3, "three"),
            new IdentifiedName(4, "four"),
            new IdentifiedName(7, "seven"),
            new IdentifiedName(8, "eight"),
            new IdentifiedName(9, "nineses")
        );

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        TableColumn<IdentifiedName, Integer> idColumn = new TableColumn<>("No");
        idColumn.setMinWidth(100);
        idColumn.setCellValueFactory(
                new PropertyValueFactory<>("id")
        );

        TableColumn<IdentifiedName, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setMinWidth(100);
        nameColumn.setCellValueFactory(
                new PropertyValueFactory<>("name")
        );

        table.setItems(data);
        table.getColumns().setAll(idColumn, nameColumn);
        table.setPrefHeight(180);

        final Label selected = new Label();
        table.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue == null) {
                selected.setText("");
                return;
            }

            selected.setText("Selected Number: " + newValue.getId());
        });

        final VBox layout = new VBox(10);
        layout.setPadding(new Insets(10));
        layout.getChildren().addAll(table, selected);
        VBox.setVgrow(table, Priority.ALWAYS);

        stage.setScene(new Scene(layout));
        stage.show();
    }

    public static class IdentifiedName {
        private final int    id;
        private final String name;

        private IdentifiedName(int id, String name) {
            this.id   = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }
    }
}