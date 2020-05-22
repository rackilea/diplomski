import java.util.Random;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(final String[] args) throws Exception {
        launch(args);
    }

    private static class Row {
        private final BooleanProperty myProp;
        public Row(final boolean value) {
            myProp = new SimpleBooleanProperty(value);
        }
        public BooleanProperty propProperty() { return myProp; }
    }

    @Override
    public void start(final Stage window) throws Exception {
        // Create a VBox to hold the table and button
        final VBox root = new VBox();
        root.setMinSize(200, 200);

        // Create the table, and enable multi-select
        final TableView<Row> table = new TableView<>();
        final MultipleSelectionModel<Row> selectionModel = table.getSelectionModel();
        selectionModel.setSelectionMode(SelectionMode.MULTIPLE);
        root.getChildren().add(table);

        // Create a column based on the value of Row.propProperty()
        final TableColumn<Row, Boolean> column = new TableColumn<>("Value");
        column.setCellValueFactory(p -> p.getValue().propProperty());
        table.getColumns().add(column);

        // Add a button below the table
        final Button button = new Button("Button");
        root.getChildren().add(button);

        // Populate the table with true/false values
        final ObservableList<Row> rows = table.getItems();
        rows.addAll(new Row(false), new Row(false), new Row(false));

        // Start a thread to randomly modify the row values
        final Random rng = new Random();
        final Thread thread = new Thread(() -> {
            // Flip the value in a randomly selected row every 10 seconds
            try {
                do {
                    final int i = rng.nextInt(rows.size());
                    System.out.println("Flipping row " + i);
                    Thread.sleep(10000);
                    final BooleanProperty prop = rows.get(i).propProperty();
                    Platform.runLater(() -> prop.set(!prop.get()));
                } while (true);
            } catch (final InterruptedException e) {
                System.out.println("Exiting Thread");
            }
        }, "Row Flipper Thread");
        thread.setDaemon(true);
        thread.start();


        // Bind the button's disable property such that the button
        //     is only enabled if one of the selected rows is true
        final ObservableList<Row> selectedRows = 
                FXCollections.observableArrayList(r -> new Observable[]{r.propProperty()});
        Bindings.bindContent(selectedRows, selectionModel.getSelectedItems());
        button.disableProperty().bind(Bindings.createBooleanBinding(() -> {
            for (int i = 0; i < selectedRows.size(); ++i) {
                if (selectedRows.get(i).propProperty().get()) {
                    return false;
                }
            }
            return true;
        }, selectedRows));

        // Show the JavaFX window
        final Scene scene = new Scene(root);
        window.setScene(scene);
        window.show();
    }
}