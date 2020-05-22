import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javafx.application.Application;
import javafx.collections.ListChangeListener.Change;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class CoordinatedTableColumns extends Application {

    @Override
    public void start(Stage primaryStage) {
        TableView<Object> firstTable = new TableView<>();
        List<TableColumn<Object, ?>> firstTableOriginalColumns = Arrays.asList(
                new TableColumn<>("Column 1"),
                new TableColumn<>("Column 2")
        );
        firstTable.getColumns().setAll(firstTableOriginalColumns);

        TableView<String> secondTable = new TableView<>();
        List<TableColumn<String, ?>> secondTableOriginalColumns = Arrays.asList(
                new TableColumn<>("Column A"),
                new TableColumn<>("Column B")
        );
        secondTable.getColumns().setAll(secondTableOriginalColumns);

        firstTable.getColumns().addListener((Change<? extends TableColumn<Object,?>> change) -> 
        secondTable.getColumns().setAll(firstTable.getColumns().stream()
            .mapToInt(firstTableOriginalColumns::indexOf)
            .mapToObj(secondTableOriginalColumns::get)
            .collect(Collectors.toList())));

        HBox root = new HBox(5, firstTable, secondTable);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}