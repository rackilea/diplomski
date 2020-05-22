import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class AnimatingBidirectionallyBoundProperties extends Application {

    @Override
    public void start(Stage primaryStage) {
        Rectangle rect1 = createDraggableRectangle();
        rect1.setX(50); rect1.setY(50);
        rect1.setFill(Color.CORNFLOWERBLUE);


        Rectangle rect2 = createDraggableRectangle();
        rect2.setX(350); rect2.setY(50);
        rect2.setFill(Color.CORAL);

        rect2.yProperty().addListener((obs, oldY, newY) -> System.out.println(oldY + " -> " + newY));

        Pane pane = new Pane(rect1, rect2);

        ToggleButton bind = new ToggleButton("Bind");
        bind.selectedProperty().addListener((obs, wasBound, isNowBound) -> {
            if (isNowBound) {
                rect2.yProperty().bindBidirectional(rect1.yProperty());
            } else {
                rect2.yProperty().unbindBidirectional(rect1.yProperty());
            }
        });

        Button sendBack = new Button("Send back to top");
        sendBack.setOnAction(e -> {
//          sendToTop(rect1);
//          sendToTop(rect2);
            sendToTop(rect1, rect2);
        });

        HBox buttons = new HBox(5, bind, sendBack);
        buttons.setAlignment(Pos.CENTER);
        buttons.setPadding(new Insets(5));

        BorderPane root = new BorderPane(pane, null, null, buttons, null);
        Scene scene = new Scene(root, 600, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void sendToTop(Rectangle... rects) {
        Timeline t = new Timeline();
        for (Rectangle r : rects) {
            t.getKeyFrames().add(new KeyFrame(Duration.seconds(0.5), new KeyValue(r.yProperty(), 50)));
        }
        t.play();
    }

    private Rectangle createDraggableRectangle() {
        Rectangle rect = new Rectangle(100,50);
        ObjectProperty<Point2D> mouseAnchor = new SimpleObjectProperty<>();
        rect.setOnMousePressed(e -> mouseAnchor.set(new Point2D(e.getSceneX(), e.getSceneY())));
        rect.setOnMouseDragged(e -> {
            double deltaX = e.getSceneX() - mouseAnchor.get().getX();
            double deltaY = e.getSceneY() - mouseAnchor.get().getY();
            rect.setX(rect.getX() + deltaX);
            rect.setY(rect.getY() + deltaY);
            mouseAnchor.set(new Point2D(e.getSceneX(), e.getSceneY()));
        });
        return rect ;
    }

    public static void main(String[] args) {
        launch(args);
    }
}