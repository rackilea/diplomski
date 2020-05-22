import java.time.LocalDate;

import javafx.application.Application;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.geometry.Bounds;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Popup;
import javafx.stage.PopupWindow;
import javafx.stage.Stage;


public class DatePickerPopupExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        Label dateLabel = new Label(LocalDate.now().toString());
        Button changeButton = new Button("Change");

        HBox root = new HBox(5, dateLabel, changeButton);
        root.setAlignment(Pos.CENTER);

        changeButton.setOnAction(event -> {
            DatePickerPopup popup = new DatePickerPopup();
            popup.valueProperty().addListener((obs, oldDate, newDate) -> {
                dateLabel.setText(newDate.toString());
            });
            Bounds buttonBds = changeButton.getBoundsInLocal();
            Point2D loc = changeButton.localToScreen(buttonBds.getMaxX(), buttonBds.getMinY());
            popup.showPopup(primaryStage, loc.getX(), loc.getY());
        });

        Scene scene = new Scene(root, 250, 150);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public class DatePickerPopup  {
        private final ReadOnlyObjectWrapper<LocalDate> value = new ReadOnlyObjectWrapper<>();

        private final Popup popup ;

        public ReadOnlyObjectProperty<LocalDate> valueProperty() {
            return value.getReadOnlyProperty();
        }

        public final LocalDate getValue() {
            return valueProperty().get();
        }
        public DatePickerPopup(LocalDate date) {

            value.set(date);

            DatePicker picker = new DatePicker(date);
            Button okButton = new Button("OK");
            okButton.setOnAction(event -> {
                popup.hide();
                value.set(picker.getValue());
            });
            Button cancelButton = new Button("Cancel");
            cancelButton.setOnAction(event -> {
                popup.hide();
            });

            BorderPane root = new BorderPane();
            root.setCenter(picker);
            HBox buttons = new HBox(5, okButton, cancelButton);
            buttons.setPadding(new Insets(5));
            buttons.setAlignment(Pos.CENTER);
            root.setBottom(buttons);

            popup = new Popup();
            popup.getContent().add(root);
        }

        public DatePickerPopup() {
            this(LocalDate.now());
        }

        public void showPopup(Stage owner, double x, double y) {
            popup.show(owner, x, y);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}