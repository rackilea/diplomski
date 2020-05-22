import javafx.application.Application;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.CubicCurve;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.stage.Stage;

public class ConnectingCubicCurve extends Application {

    @Override
    public void start(Stage primaryStage) {
        Circle start = createDraggingCircle(100, 100, 10, Color.CORAL);
        Circle end = createDraggingCircle(300, 300, 10, Color.CORAL);
        Connection connection = new Connection();
        connection.setFromCircle(start);
        connection.setToCircle(end);

        Pane pane = new Pane(connection.asNode(), start, end);

        pane.setOnMouseClicked(e -> System.out.println("Click on pane"));
        connection.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> System.out.println("Click on connection"));
        start.setOnMouseClicked(e -> System.out.println("Click on start"));
        end.setOnMouseClicked(e -> System.out.println("Click on end"));

        Scene scene = new Scene(pane, 600, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Circle createDraggingCircle(double centerX, double centerY, double radius, Paint fill) {
        Circle circle = new Circle(centerX, centerY, radius, fill);

        ObjectProperty<Point2D> mouseLoc = new SimpleObjectProperty<>();

        circle.setOnDragDetected(e -> 
            mouseLoc.set(new Point2D(e.getSceneX(), e.getSceneY())));
        circle.setOnMouseReleased(e -> mouseLoc.set(null));
        circle.setOnMouseDragged(e -> {
            if (mouseLoc.get() == null) return ;
            double x = e.getSceneX() ;
            double y = e.getSceneY() ;
            double deltaX = x - mouseLoc.get().getX() ;
            double deltaY = y - mouseLoc.get().getY() ;
            circle.setCenterX(circle.getCenterX() + deltaX);
            circle.setCenterY(circle.getCenterY() + deltaY);
            mouseLoc.set(new Point2D(x, y));
        });

        return circle ;
    }

    public static class Connection {

        private Path connectingLine ;
        private CubicCurve fill ;
        private Group group ;

        private ObjectProperty<Circle> fromCircle = new SimpleObjectProperty<>();
        private ObjectProperty<Circle> toCircle = new SimpleObjectProperty<>();

        public Connection() {
            connectingLine = new Path();

            MoveTo start = new MoveTo();
            CubicCurveTo curve = new CubicCurveTo();

            CubicCurveTo reverseCurve = new CubicCurveTo();
            reverseCurve.xProperty().bind(start.xProperty());
            reverseCurve.yProperty().bind(start.yProperty());
            reverseCurve.controlX1Property().bind(curve.controlX2Property());
            reverseCurve.controlX2Property().bind(curve.controlX1Property());
            reverseCurve.controlY1Property().bind(curve.controlY2Property());
            reverseCurve.controlY2Property().bind(curve.controlY1Property());

            connectingLine.getElements().addAll(start, curve, reverseCurve);

            fill = new CubicCurve();

            fill.setMouseTransparent(true);

            group = new Group();
            group.getChildren().addAll(fill, connectingLine);

            connectingLine.setStroke(Color.BLACK);
            connectingLine.setStrokeWidth(3);
            fill.setStrokeWidth(0);
            fill.setStroke(Color.TRANSPARENT);
            fill.setFill(Color.ALICEBLUE);

            fill.startXProperty().bind(start.xProperty());
            fill.startYProperty().bind(start.yProperty());
            fill.controlX1Property().bind(curve.controlX1Property());
            fill.controlX2Property().bind(curve.controlX2Property());
            fill.controlY1Property().bind(curve.controlY1Property());
            fill.controlY2Property().bind(curve.controlY2Property());
            fill.endXProperty().bind(curve.xProperty());
            fill.endYProperty().bind(curve.yProperty());

            fromCircle.addListener((obs, oldCircle, newCircle) -> {
                if (oldCircle != null) {
                    start.xProperty().unbind();
                    start.yProperty().unbind();
                }
                if (newCircle != null) {
                    start.xProperty().bind(newCircle.centerXProperty());
                    start.yProperty().bind(newCircle.centerYProperty());
                }
            });

            toCircle.addListener((obs, oldCircle, newCircle) -> {
                if (oldCircle != null) {
                    curve.xProperty().unbind();
                    curve.yProperty().unbind();
                }
                if (newCircle != null) {
                    curve.xProperty().bind(newCircle.centerXProperty());
                    curve.yProperty().bind(newCircle.centerYProperty());
                }
            });

            ChangeListener<Number> endpointListener = (obs, oldValue, newValue) -> {
                Point2D startPoint = new Point2D(start.getX(), start.getY());
                Point2D end = new Point2D(curve.getX(), curve.getY());
                Point2D vector = end.subtract(startPoint);
                Point2D perpVector = new Point2D(-vector.getY(), vector.getX());
                Point2D control1 = startPoint.add(perpVector);
                Point2D control2 = end.add(perpVector);
                curve.setControlX1(control1.getX());
                curve.setControlX2(control2.getX());
                curve.setControlY1(control1.getY());
                curve.setControlY2(control2.getY());
            };

            start.xProperty().addListener(endpointListener);
            start.yProperty().addListener(endpointListener);
            curve.xProperty().addListener(endpointListener);
            curve.yProperty().addListener(endpointListener);
        }

        public <E extends Event> void addEventHandler(EventType<E> eventType, EventHandler<E> eventHandler) {
            connectingLine.addEventHandler(eventType, eventHandler);
        }

        public <E extends Event> void removeEventHandler(EventType<E> eventType, EventHandler<E> eventHandler) {
            connectingLine.removeEventHandler(eventType, eventHandler);
        }

        public Node asNode() {
            return group ;
        }


        public final ObjectProperty<Circle> fromCircleProperty() {
            return this.fromCircle;
        }

        public final javafx.scene.shape.Circle getFromCircle() {
            return this.fromCircleProperty().get();
        }

        public final void setFromCircle(final javafx.scene.shape.Circle fromCircle) {
            this.fromCircleProperty().set(fromCircle);
        }

        public final ObjectProperty<Circle> toCircleProperty() {
            return this.toCircle;
        }

        public final javafx.scene.shape.Circle getToCircle() {
            return this.toCircleProperty().get();
        }

        public final void setToCircle(final javafx.scene.shape.Circle toCircle) {
            this.toCircleProperty().set(toCircle);
        }


    }

    public static void main(String[] args) {
        launch(args);
    }
}