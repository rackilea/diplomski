package tester;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Tester extends Application
{

    @Override
    public void start(Stage primaryStage)
    {

        TableView<LineItem> table = new TableView<>();
        List<Map<String, String>> databaseObject = getDatabaseObject();

        for (String key : databaseObject.get(0).keySet())
        {
            TableColumn<LineItem, String> col = new TableColumn<>(key);
            col.setCellValueFactory((TableColumn.CellDataFeatures<LineItem, String> cellData) -> cellData.getValue().fieldProperty(key));            
            table.getColumns().add(col);

        }
        List<LineItem> data = new ArrayList<>();
        LineItem sequence1 = new LineItem(databaseObject.get(0));
        LineItem sequence2 = new LineItem(databaseObject.get(1));
        data.add(sequence1);
        data.add(sequence2);

        table.setItems(FXCollections.observableArrayList(data));

        table.setPrefWidth(500);

        HBox root = new HBox();
        root.getChildren().addAll(table);

        Scene scene = new Scene(root, 500, 500);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        launch(args);
    }

    private List<Map<String, String>> getDatabaseObject()
    {
        List<Map<String, String>> values = new ArrayList<>();

        Map<String, String> record1 = new HashMap<>();
        record1.put("firstName", "Joe");
        record1.put("lastName", "Blob");
        record1.put("address", "95 circle ave");
        record1.put("city", "Toronto");
        record1.put("postalCode", "L9Y4Z4");
        values.add(record1);

        Map<String, String> record2 = new HashMap<>();
        record2.put("firstName", "Sarah");
        record2.put("lastName", "Blob");
        record2.put("address", "92 main st");
        record2.put("city", "London");
        record2.put("postalCode", "T9Y4K4");
        values.add(record2);

        return values;
    }

}