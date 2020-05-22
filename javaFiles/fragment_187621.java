import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class TableViewDemo2 extends Application
{

    double sceneX, sceneY;

    Circle circle = new Circle(15, Color.RED);
    Circle circle2 = new Circle(15, Color.BLUE);
    Line line = new Line();

    private Line connectLines(Line line, Circle startNode, Circle endNode)
    {
        line.startXProperty().bind(startNode.centerXProperty());
        line.startYProperty().bind(startNode.centerYProperty());
        line.endXProperty().bind(endNode.centerXProperty());
        line.endYProperty().bind(endNode.centerYProperty());

        return line;
    }
    //mouse pressed event
    EventHandler<MouseEvent> mousePressed = new EventHandler<MouseEvent>()
    {
        @Override
        public void handle(MouseEvent e)
        {
            System.out.println("pressed");

            sceneX = e.getSceneX();
            sceneY = e.getSceneY();

            Circle tempCircle = ((Circle) e.getSource());
            tempCircle.toFront();
        }
    };

    //mouse dragged event
    EventHandler<MouseEvent> mouseDragged = new EventHandler<MouseEvent>()
    {
        @Override
        public void handle(MouseEvent e)
        {
            System.out.println(Math.hypot(line.getBoundsInLocal().getWidth(), line.getBoundsInLocal().getHeight()));

            System.out.println("dragged");
            double offSetX = e.getSceneX() - sceneX;
            double offSetY = e.getSceneY() - sceneY;

            Circle tempCircle = ((Circle) (e.getSource()));
            tempCircle.setCenterX(tempCircle.getCenterX() + offSetX);
            tempCircle.setCenterY(tempCircle.getCenterY() + offSetY);

            if (Math.hypot(line.getBoundsInLocal().getWidth(), line.getBoundsInLocal().getHeight()) >= 100) {
                tempCircle.setCenterX(tempCircle.getCenterX() - offSetX);
                tempCircle.setCenterY(tempCircle.getCenterY() - offSetY);
            }

            sceneX = e.getSceneX();
            sceneY = e.getSceneY();
        }
    };


    @Override
    public void start(Stage stage)
    {

        circle.setOnMouseDragged(mouseDragged);
        circle2.setOnMouseDragged(mouseDragged);

        Line returnLine = connectLines(line, circle, circle2);

        StackPane root = new StackPane(new Pane(circle, circle2, returnLine));

        stage.setTitle("TableView (o7planning.org)");

        Scene scene = new Scene(root, 450, 300);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}