import javafx.application.Application;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MCVE extends Application {
    @Override
    public void start(Stage stage) {
        VBox content = new VBox(5);
        content.setPadding(new Insets(10));

        Hyperlink link = new Hyperlink("Hyperlink");

        Button fireButton = new Button("Fire hyperlink");
        fireButton.setOnAction(e -> link.fire());

        BooleanProperty mouseClicked = new SimpleBooleanProperty(false);

        link.setOnMousePressed(e -> {
            System.out.println("Mouse click");
            mouseClicked.set(true);
        });

        link.setOnAction(e -> {
            if (!mouseClicked.get()) {
                System.out.println("No mouse click");
            }
            mouseClicked.set(false);
        });

        content.getChildren().addAll(link, fireButton);

        stage.setScene(new Scene(content));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}