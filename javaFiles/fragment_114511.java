mport javafx.application.Application;
import javafx.collections.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Callback;

public class ListViewSample extends Application {

    ListView<String> list = new ListView<String>();
    ObservableList<String> data = FXCollections.observableArrayList(
            "chocolate", "salmon", "gold", "coral", "darkorchid",
            "darkgoldenrod", "lightsalmon", "black", "rosybrown", "blue",
            "blueviolet", "brown");
    final Label label = new Label();

    @Override
    public void start(Stage stage) {
        VBox box = new VBox();
        Scene scene = new Scene(box, 200, 200);
        stage.setScene(scene);
        stage.setTitle("ListViewSample");
        box.getChildren().addAll(list, label);
        VBox.setVgrow(list, Priority.ALWAYS);

        label.setLayoutX(10);
        label.setLayoutY(115);
        label.setFont(Font.font("Verdana", 20));

        list.setItems(data);

        list.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
            @Override public ListCell<String> call(ListView<String> list) {
                return new ColorRectCell();
            }
        });

        list.getSelectionModel().selectedItemProperty().addListener(
                (ov, old_val, new_val) -> {
                        label.setText(new_val);
                        label.setTextFill(Color.web(new_val));
                });
        stage.show();
    }

    static class ColorRectCell extends ListCell<String> {
        final Rectangle swatch = new Rectangle(30, 30);
        final Tooltip tip = new Tooltip();

        public ColorRectCell() {
            tip.setGraphic(swatch);
        }

        @Override
        public void updateItem(String color, boolean empty) {
            super.updateItem(color, empty);

            if (color != null) {
                swatch.setFill(Color.valueOf(color.toUpperCase()));
                setText(color);
                setTooltip(tip);
            } else {
                setText("");
                setTooltip(null);
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}