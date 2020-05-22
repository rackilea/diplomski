import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.SubScene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Material;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape3D;
import javafx.scene.shape.Sphere;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Transform;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;

public class ScreenSelectionNew extends Application {

    private final PerspectiveCamera camera = new PerspectiveCamera(true);

    private final XFormWorld world = new XFormWorld();

    private double mousePosX, mousePosY, mouseOldX, mouseOldY;

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane main = new BorderPane();
        StackPane stackPane = new StackPane();

        SubScene subScene = setupSubScene(main);
        subScene.heightProperty().bind(stackPane.heightProperty());
        subScene.widthProperty().bind(stackPane.widthProperty());
        stackPane.getChildren().addAll(subScene, setupControls());

        MenuBar menu = new MenuBar(new Menu("File"));

        main.setTop(menu);
        main.setCenter(stackPane);
        Scene scene = new Scene(main);

        stage.setScene(scene);
        stage.setWidth(800);
        stage.setHeight(800);
        stage.show();
    }

    private SubScene setupSubScene(Pane parent) {
        Collection<Shape3D> worldContent = createWorld();
        world.getChildren().addAll(worldContent);

        SubScene subScene = new SubScene(world, -1, -1, true, SceneAntialiasing.BALANCED);
        subScene.setCamera(camera);
        subScene.setPickOnBounds(true);
        camera.setFieldOfView(60);

        RectangleSelect rs = new RectangleSelect(parent, worldContent);

        subScene.setOnMousePressed(me -> {
            mousePosX = me.getX();
            mousePosY = me.getY();
        });

        subScene.setOnMouseDragged(me -> {
            if (me.isSecondaryButtonDown()) {
                rs.onMouseDragged(me);
            } else if (me.isPrimaryButtonDown()) {
                mouseOldX = mousePosX;
                mouseOldY = mousePosY;
                mousePosX = me.getX();
                mousePosY = me.getY();
                double mouseDeltaX = (mousePosX - mouseOldX);
                double mouseDeltaY = (mousePosY - mouseOldY);
                world.rx(mouseDeltaY * 180.0 / subScene.getHeight());
                world.ry(-mouseDeltaX * 180.0 / subScene.getWidth());
            }
        });

        subScene.setOnMouseReleased(me -> rs.onMouseDragReleased(me));

        subScene.setOnMouseClicked(me -> {
            if (me.getButton() == MouseButton.SECONDARY && me.isStillSincePress()) {
                rs.clearSelection();
            }
        });

        return subScene;
    }

    private Pane setupControls() {
        Slider zoom = new Slider(-100, 0, -50);
        camera.translateZProperty().bind(zoom.valueProperty());

        Button reset = new Button("Reset");
        reset.setOnAction(eh -> {
            world.reset();
            zoom.setValue(-50);
        });

        HBox controls = new HBox(new Label("Zoom: "), zoom, reset);
        AnchorPane anchorPane = new AnchorPane(controls);
        anchorPane.setPickOnBounds(false);
        return anchorPane;
    }

    private Collection<Shape3D> createWorld() {

        List<Shape3D> shapes = new ArrayList<>();

        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < 4000; i++) {
            double x = (random.nextDouble() - 0.5) * 30;
            double y = (random.nextDouble() - 0.5) * 30;
            double z = (random.nextDouble() - 0.5) * 30;

            Sphere point = new Sphere(0.2);
            point.setMaterial(new PhongMaterial(Color.SKYBLUE));
            point.getTransforms().add(new Translate(x, y, z));
            shapes.add(point);
        }

        return shapes;
    }

    public static void main(String[] args) {
        launch(args);
    }

    public class XFormWorld extends Group {
        Transform rotation = new Rotate();

        public XFormWorld() {
            getTransforms().addAll(rotation);
        }

        public void reset() {
            rotation = new Rotate();
            getTransforms().set(0, rotation);
        }

        public void rx(double angle) {
            Point3D axis = new Point3D(rotation.getMxx(), rotation.getMxy(), rotation.getMxz());
            rotation = rotation.createConcatenation(new Rotate(angle, axis));
            getTransforms().set(0, rotation);
        }

        public void ry(double angle) {
            Point3D axis = new Point3D(rotation.getMyx(), rotation.getMyy(), rotation.getMyz());
            rotation = rotation.createConcatenation(new Rotate(angle, axis));
            getTransforms().set(0, rotation);
        }
    }

    public class RectangleSelect {

        private static final int START_X = 0;
        private static final int START_Y = 1;
        private static final int END_X = 2;
        private static final int END_Y = 3;

        private double[] sceneCoords = new double[2]; //mouse drag x, y in scene coords 
        private double[] screenCoords = new double[2]; //mouse drag current x, y in screen coords
        private double[] boundsInScreenCoords = new double[4]; //top left x, y, bottom right x,y in screen coords
        private Collection<Shape3D> world;

        private PhongMaterial selected = new PhongMaterial(Color.YELLOW);
        private Rectangle rectangle;

        public RectangleSelect(Pane pane, Collection<Shape3D> world) {
            sceneCoords[START_X] = Double.MIN_VALUE;
            sceneCoords[START_Y] = Double.MIN_VALUE;
            rectangle = new Rectangle();
            rectangle.setStroke(Color.RED);
            rectangle.setOpacity(0.0);
            rectangle.setMouseTransparent(true);
            rectangle.setFill(null);

            this.world = world;
            pane.getChildren().add(rectangle);
        }

        public void onMouseDragged(MouseEvent me) {
            clearSelection();
            if (sceneCoords[START_X] == Double.MIN_VALUE) {
                sceneCoords[START_X] = me.getSceneX();
                sceneCoords[START_Y] = me.getSceneY();
                screenCoords[START_X] = me.getScreenX();
                screenCoords[START_Y] = me.getScreenY();
            }
            double sceneX = me.getSceneX();
            double sceneY = me.getSceneY();
            double screenX = me.getScreenX();
            double screenY = me.getScreenY();

            double topX = Math.min(sceneCoords[START_X], sceneX);
            double bottomX = Math.max(sceneCoords[START_X], sceneX);
            double leftY = Math.min(sceneCoords[START_Y], sceneY);
            double rightY = Math.max(sceneCoords[START_Y], sceneY);

            boundsInScreenCoords[START_X] = Math.min(screenCoords[START_X], screenX);
            boundsInScreenCoords[END_X] = Math.max(screenCoords[START_X], screenX);
            boundsInScreenCoords[START_Y] = Math.min(screenCoords[START_Y], screenY);
            boundsInScreenCoords[END_Y] = Math.max(screenCoords[START_Y], screenY);

            world.forEach(this::selectIfInBounds);

            rectangle.setX(topX);
            rectangle.setY(leftY);
            rectangle.setWidth(bottomX - topX);
            rectangle.setHeight(rightY - leftY);
            rectangle.setOpacity(1.0);
        }

        private void selectIfInBounds(Shape3D node) {
            Point2D screenCoods = node.localToScreen(0.0, 0.0, 0.0);
            if (screenCoods.getX() > boundsInScreenCoords[START_X] &&
                screenCoods.getY() > boundsInScreenCoords[START_Y] &&
                screenCoods.getX() < boundsInScreenCoords[END_X] &&
                screenCoods.getY() < boundsInScreenCoords[END_Y]) {
                Material m = node.getMaterial();
                node.getProperties().put("material", m);
                node.setMaterial(selected);
            }
        }

        private void unselect(Shape3D node) {
            Material m = (Material) node.getProperties().get("material");
            if (m != null) {
                node.setMaterial(m);
            }
        }

        public void onMouseDragReleased(MouseEvent me) {
            rectangle.setOpacity(0.0);
            sceneCoords[START_X] = Double.MIN_VALUE;
            sceneCoords[START_Y] = Double.MIN_VALUE;
        }

        public void clearSelection() {
            world.forEach(this::unselect);
        }
    }
}