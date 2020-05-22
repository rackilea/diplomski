import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PickingDates extends Application {
    @Override
    public void start(final Stage stage) throws Exception {
        DatePicker picker = new DatePicker();
        Label typedData = new Label();
        picker.getEditor().textProperty().addListener((observable, oldValue, newValue) -> {
            typedData.setText(newValue);
        });
        Button button = new Button("Button");

        final VBox layout = new VBox(10, typedData, picker, button);
        layout.setPadding(new Insets(10));
        Scene scene = new Scene(layout);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}