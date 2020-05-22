import java.util.ArrayList;

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
        ArrayList<Circle> list = new ArrayList<>();

        Rectangle rectangle1 = new Rectangle(10, 10, 175, 80);
        rectangle1.setStroke(Color.BLACK);
        rectangle1.setFill(Color.WHITE);
        Pane rectangle2 = new Pane();
        rectangle2.relocate(250, 75);
        rectangle2.setPrefSize(300,  200);
        rectangle2.setStyle("-fx-border-color: black;");

        Text text = new Text(20, 33, "INSTRUCTION\n"
                + "Add: Left Click\nRemove: Right Click");

        pane.setOnMouseClicked(e -> {
            if (e.getButton() == MouseButton.PRIMARY) {
                Circle circle = new Circle(e.getX(), e.getY(), 10);
                list.add(circle);
                circle.setStroke(Color.BLACK);
                circle.setFill(Color.WHITE);

                if (circle.getCenterX() - rectangle2.getBoundsInParent().getMinX() < 10) {
                    circle.setCenterX(rectangle2.getBoundsInParent().getMinX() + 10);
                } else if (circle.getCenterY() - rectangle2.getBoundsInParent().getMinY() < 10) {
                    circle.setCenterY(rectangle2.getBoundsInParent().getMinY() + 10);
                } else if (rectangle2.getBoundsInParent().getMaxX()
                        - circle.getCenterX() < 10) {
                    circle.setCenterX(rectangle2.getBoundsInParent().getMaxX() - 10);
                } else if (rectangle2.getBoundsInParent().getMaxY()
                        - circle.getCenterY() < 10) {
                    circle.setCenterY(rectangle2.getBoundsInParent().getMaxY() - 10);
                }
                pane.getChildren().add(circle);
            }

            else if (e.getButton() == MouseButton.SECONDARY) {
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).contains(e.getX(), e.getY())) {
                        pane.getChildren().remove(list.get(i));
                        list.remove(i);
                        break;
                    }
                }
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