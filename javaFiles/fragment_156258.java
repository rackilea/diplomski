import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class PaymentPad extends Application {

    private IntegerProperty totalCents = new SimpleIntegerProperty();

    @Override
    public void start(Stage primaryStage) {
        GridPane pad = new GridPane();
        pad.setHgap(2);
        pad.setVgap(2);

        pad.add(createNumberButton(0), 0, 4);
        for (int i = 1 ; i <= 9 ; i++) {
            int columnIndex = (i-1) % 3;
            int rowIndex = 3 - (i-1) /3 ;
            pad.add(createNumberButton(i), columnIndex, rowIndex);
        }

        Button clearButton = createButton("C");
        clearButton.setOnAction(e -> totalCents.set(0));
        pad.add(clearButton, 1, 4, 2, 1);

        Label display = new Label();
        display.textProperty().bind(totalCents.divide(100.0).asString("$%.2f"));
        display.setMaxWidth(Double.MAX_VALUE);
        display.setAlignment(Pos.CENTER_RIGHT);
        pad.add(display, 0, 0, 3, 1);

        Scene scene = new Scene(pad);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Button createNumberButton(int value) {
        Button button = createButton(Integer.toString(value));
        button.setOnAction(e -> totalCents.set(totalCents.get()*10+value));
        return button ;
    }

    private Button createButton(String text) {
        Button button = new Button(text);
        button.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        GridPane.setFillHeight(button, true);
        GridPane.setFillWidth(button, true);
        return button ;     
    }

    public static void main(String[] args) {
        launch(args);
    }
}