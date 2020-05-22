import javafx.application.Application;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.shape.StrokeType;
import javafx.stage.Stage;

public class CollisionDetection extends Application {

    @Override
    public void start(Stage primaryStage) {

        Label label = new Label();
        Group groupA = new Group();
        Group groupB = new Group();

        Rectangle objectA = new Rectangle(50, 30);
        objectA.setFill(Paint.valueOf("red"));
        objectA.setX(100);
        objectA.setY(100);
        objectA.setRotate(10);
        objectA.setSmooth(true);

        Rectangle objectB = new Rectangle(80, 40);
        objectB.setFill(Paint.valueOf("blue"));
        objectB.setRotate(-10);
        objectB.setX(115);
        objectB.setY(50);        

        groupB.getChildren().add(objectB);
        groupA.getChildren().addAll(objectA,groupB);

        groupA.getChildren().add(createBoundsRectangle(objectA.getBoundsInParent()));
        groupA.getChildren().add(createBoundsRectangle(objectB.getBoundsInParent()));

        Shape intersect = Shape.intersect(objectA, objectB);

        if (intersect.getBoundsInParent().getWidth() > 0) {
            label.setText("ObjectA intersects ObjectB");
        } else {
            label.setText("ObjectA does not intersect ObjectB");
        }

        BorderPane root = new BorderPane(groupA);
        root.setBottom(label);
        Scene scene = new Scene(root, 300, 250);        

        primaryStage.setTitle("Collision Detection");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Rectangle createBoundsRectangle(Bounds bounds) {
        Rectangle rect = new Rectangle();       

        rect.setFill(Color.TRANSPARENT);
        rect.setStroke(Color.LIGHTGRAY.deriveColor(1, 1, 1, 0.5));
        rect.setStrokeType(StrokeType.INSIDE);
        rect.setStrokeWidth(3);

        rect.setX(bounds.getMinX());
        rect.setY(bounds.getMinY());
        rect.setWidth(bounds.getWidth());
        rect.setHeight(bounds.getHeight());
        return rect;
      }


    public static void main(String[] args) {
        launch(args);
    }  
}