import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ComboBoxWithSections extends Application {

    @Override
    public void start(Stage primaryStage) {
        ComboBox<ComboBoxItem> combo = new ComboBox<>();
        combo.getItems().addAll(
            new ComboBoxItem("Short Duration", false),
            new ComboBoxItem("Last Hour",      true),
            new ComboBoxItem("Last 2 hours",   true),
            new ComboBoxItem("Last 24 hours",  true),
            new ComboBoxItem("",               false),
            new ComboBoxItem("Long Duration",  false),
            new ComboBoxItem("Last Month",     true),
            new ComboBoxItem("Last Year",      true)            
        );

        combo.setCellFactory(listView -> new ListCell<ComboBoxItem>() {
            @Override
            public void updateItem(ComboBoxItem item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setText(null);
                    setDisable(false);
                } else {
                    setText(item.toString());
                    setDisable(! item.isSelectable());
                }
            }
        });

        BorderPane root = new BorderPane(null, combo, null, null, null);
        primaryStage.setScene(new Scene(root, 250, 400));
        primaryStage.show();
    }

    public static class ComboBoxItem {
        private final String name ;
        private final boolean selectable ;

        public ComboBoxItem(String name, boolean selectable) {
            this.name = name ;
            this.selectable = selectable ;
        }

        public String getName() {
            return name ;
        }

        public boolean isSelectable() {
            return selectable ;
        }

        @Override
        public String toString() {
            return name ;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}