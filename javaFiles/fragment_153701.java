import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class BoundingRectangle extends Application {
    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();

        Rectangle rectangle1 = new Rectangle(10, 10, 175, 80);
        rectangle1.setStroke(Color.BLACK);
        rectangle1.setFill(Color.WHITE);

        Pane rectangle2 = new Pane();
        rectangle2.relocate(250, 75);
        rectangle2.setPrefSize(300,  200);
        rectangle2.setStyle("-fx-border-color: black;");

        Text text = new Text(20, 33, "INSTRUCTION\n"
                + "Add: Left Click\nRemove: Right Click");

        rectangle2.setOnMouseClicked(e -> {
            if (e.getButton() == MouseButton.PRIMARY) {
                Circle circle = new Circle(e.getX(), e.getY(), 10);

                circle.setOnMouseClicked(evt -> {
                    if (evt.getButton() == MouseButton.SECONDARY) {
                        rectangle2.getChildren().remove(circle);
                    }
                });

                circle.setStroke(Color.BLACK);
                circle.setFill(Color.WHITE);

                rectangle2.getChildren().add(circle);
            }


        });
        pane.getChildren().addAll(rectangle1, rectangle2, text);

        Scene scene = new Scene(pane, 600, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("BoundingRectangle");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}