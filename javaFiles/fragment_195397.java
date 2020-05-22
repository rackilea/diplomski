import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.util.Map;
import java.util.TreeMap;

public class Main extends Application {

    Map<Character, Integer> countCharacters = new TreeMap<Character, Integer>();

    @Override
    public void start(Stage primaryStage) throws Exception {

        // sample data


        int total = 0;
        countCharacters.put('A', 2);
        countCharacters.put('B', 5);
        countCharacters.put('C', 10);

        if (!countCharacters.isEmpty()) {
            for (Map.Entry<Character, Integer> entry : countCharacters.entrySet()) {
                total += entry.getValue();
            }

            for (Map.Entry<Character, Integer> entry : countCharacters.entrySet()) {
                System.out.println(entry.getKey() + ":\t" + entry.getValue() + "  \t: \t " + percentCount(entry.getValue(), total) + "%");
            }

        }

        TableColumn<Map.Entry<Character, Integer>, String> column1 = new TableColumn<>("Key");
        column1.setCellValueFactory(
                new Callback<CellDataFeatures<Map.Entry<Character, Integer>, String>, ObservableValue<String>>() {
                    @Override
                    public ObservableValue<String> call(CellDataFeatures<Map.Entry<Character, Integer>, String> param) {
                        return new SimpleStringProperty(String.valueOf(param.getValue().getKey()));
                    }
                });

        TableColumn<Map.Entry<Character, Integer>, String> column2 = new TableColumn<>("Value");
        column2.setCellValueFactory(
                new Callback<CellDataFeatures<Map.Entry<Character, Integer>, String>, ObservableValue<String>>() {
                    @Override
                    public ObservableValue<String> call(CellDataFeatures<Map.Entry<Character, Integer>, String> param) {
                        return new SimpleStringProperty(String.valueOf(param.getValue().getValue()));
                    }
                });

        ObservableList<Map.Entry<Character, Integer>> items = FXCollections.observableArrayList(countCharacters.entrySet());
        final TableView<Map.Entry<Character, Integer>> table = new TableView<>(items);
        table.getColumns().addAll(column1, column2);

        primaryStage.setTitle("Alice");
        primaryStage.setScene(new Scene(table, 300, 275));
        primaryStage.show();
    }

    public static float percentCount(float number, int total) {
        return (number / total) * 100;
    }

    public static void main(String[] args) {
        launch(args);
    }
}