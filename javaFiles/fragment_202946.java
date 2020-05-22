import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.util.Optional;

public class DialogSample extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Button showButton = new Button("show");
        showButton.setOnAction(event -> showDialog(stage));
        showButton.setPrefWidth(100);
        stage.setScene(new Scene(showButton));
        stage.show();

        showButton.fire();
    }

    private void showDialog(Stage stage) {
        TextInputDialog dialog = new TextInputDialog();
        dialog.initOwner(stage);
        dialog.setTitle("Delimiter");
        dialog.setHeaderText("Enter the delimiter");

        final Button ok = (Button) dialog.getDialogPane().lookupButton(ButtonType.OK);
        ok.addEventFilter(ActionEvent.ACTION, event ->
            System.out.println("OK was definitely pressed")
        );

        final Button cancel = (Button) dialog.getDialogPane().lookupButton(ButtonType.CANCEL);
        cancel.addEventFilter(ActionEvent.ACTION, event ->
            System.out.println("Cancel was definitely pressed")
        );

        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()) {
            System.out.println("Result present => OK was pressed");
            System.out.println("Result: " + result.get());
        } else {
            System.out.println("Result not present => Cancel might have been pressed");
        }    
    }

    public static void main(String[] args) {
        Application.launch();
    }
}