import javafx.application.Application;
import javafx.event.*;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;

public class DialogClosing extends Application {
    @Override public void start(final Stage stage) {
        final Button showDialog = new Button("Show Dialog");
        showDialog.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent actionEvent) {
                showDialog(stage, showDialog);
            }
        });

        StackPane layout = new StackPane();
        layout.getChildren().setAll(
            showDialog
        );

        layout.setStyle("-fx-padding: 10px;");
        stage.setScene(
            new Scene(
                layout
            )
        );
        stage.show();
    }

    private Stage showDialog(Window parent, final Node showControlNode) {
        showControlNode.setDisable(true);

        final Stage dialog = new Stage();
        dialog.initOwner(parent);
        dialog.initStyle(StageStyle.UTILITY);
        dialog.setX(parent.getX());
        dialog.setY(parent.getY() + parent.getHeight());

        Button closeDialog = new Button("Close Dialog");
        closeDialog.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                dialog.close();
            }
        });
        dialog.setOnHidden(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent windowEvent) {
                showControlNode.setDisable(false);
            }
        });

        VBox layout = new VBox(10);
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(
            new Label("Hello World!"),
            closeDialog
        );
        layout.setStyle("-fx-padding: 10px;");

        Scene scene = new Scene(
            layout,
            125,
            100
        );

        dialog.setScene(scene);
        dialog.show();

        return dialog;
    }

    public static void main(String[] args) { launch(args); }
}