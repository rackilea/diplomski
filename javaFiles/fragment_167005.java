import java.util.Arrays;
import java.util.List;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 *
 * @author nonfrt
 */
public class TableStuff extends Application {

    @Override
    public void start(Stage primaryStage) {

        // Create the data structure
        String[][] data = new String[5][2];
        data[0] = new String[]{"Jon Skeet","876k"};
        data[1] = new String[]{"Darin Dimitrov","670k"};
        data[2] = new String[]{"BalusC","660k"};
        data[3] = new String[]{"Hans Passant","635k"};
        data[4] = new String[]{"Marc Gravell","610k"};

        // Create the table and columns
        TableView<String[]> tv = new TableView();
            TableColumn<String[],String> nameColumn = new TableColumn();
                nameColumn.setText("Name Column");

            TableColumn<String[],String> valueColumn = new TableColumn();
                valueColumn.setText("Value Column");
        tv.getColumns().addAll(nameColumn,valueColumn);

        // Add cell value factories
//        nameColumn.setCellValueFactory((p)->{
//                String[] x = p.getValue();
//                return new SimpleStringProperty(x != null && x.length>0 ? x[0] : "<no name>");
//        });
//
//        valueColumn.setCellValueFactory((p)->{
//                String[] x = p.getValue();
//                return new SimpleStringProperty(x != null && x.length>1 ? x[1] : "<no value>");
//        });
        nameColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<String[], String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<String[], String> p) {
                String[] x = p.getValue();
                if (x != null && x.length>0) {
                    return new SimpleStringProperty(x[0]);
                } else {
                    return new SimpleStringProperty("<no name>");
                }
            }
        });

        valueColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<String[], String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<String[], String> p) {
                String[] x = p.getValue();
                if (x != null && x.length>1) {
                    return new SimpleStringProperty(x[1]);
                } else {
                    return new SimpleStringProperty("<no value>");
                }
            }
        });

        // Add Data
        tv.getItems().addAll(Arrays.asList(data));

        // Finish setting the stage
        StackPane root = new StackPane();
        root.getChildren().add(tv);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Cell Value Factory Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}