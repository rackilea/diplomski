import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;

public class StageStyles_Demo extends Application {
    @Override
    public void start(Stage stage) throws Exception {


        Button button1 = new Button("Open Decorated");
        button1.setOnAction(e -> {
            StackPane node = new StackPane(new Label("DECORATED"));
            node.setPadding(new Insets(15));
            node.setStyle("-fx-background-color:#999999;-fx-font-size:16px;");

            StackPane body = new StackPane(new Group(node));
            Stage stg = new Stage();
            stg.initStyle(StageStyle.DECORATED);
            stg.setScene(new Scene(body, 300, 300, Color.TRANSPARENT));
            stg.show();
        });


        Button button2 = new Button("Open Utility");
        button2.setOnAction(e -> {
            StackPane node = new StackPane(new Label("UTILITY"));
            node.setPadding(new Insets(15));
            node.setStyle("-fx-background-color:#999999;-fx-font-size:16px;");

            StackPane body = new StackPane(new Group(node));
            Stage stg = new Stage();
            stg.initStyle(StageStyle.UTILITY);
            stg.setScene(new Scene(body, 300, 300, Color.TRANSPARENT));
            stg.show();
        });


        Button button3 = new Button("Open Undecorated");
        button3.setOnAction(e -> {
            StackPane node = new StackPane(new Label("UNDECORATED"));
            node.setPadding(new Insets(15));
            node.setStyle("-fx-background-color:red;-fx-font-size:16px;");

            StackPane body = new StackPane(new Group(node));
            VBox.setVgrow(body, Priority.ALWAYS);
            VBox root = new VBox(buildDraggableHeader(), body);
            root.setStyle("-fx-border-width:1px;-fx-border-color:red;-fx-background-color:transparent;");

            Stage stg = new Stage();
            stg.initStyle(StageStyle.UNDECORATED);
            stg.setScene(new Scene(root, 300, 300, Color.TRANSPARENT));
            // EXPLICITLY INCLUDING THE RESIZE LOGIC !!!
            stg.getScene().addEventFilter(MouseEvent.ANY, new ResizeHandler(stg));
            stg.show();
        });

        Button button4 = new Button("Open Transparent");
        button4.setOnAction(e -> {
            StackPane node = new StackPane(new Label("TRANSPARENT"));
            node.setPadding(new Insets(15));
            node.setStyle("-fx-background-color:green;-fx-font-size:16px;");

            StackPane body = new StackPane(new Group(node));
            VBox.setVgrow(body, Priority.ALWAYS);
            VBox root = new VBox(buildDraggableHeader(), body);
            root.setStyle("-fx-border-width:1px;-fx-border-color:green;-fx-background-color:transparent;");

            Stage stg = new Stage();
            stg.initStyle(StageStyle.TRANSPARENT);
            stg.setScene(new Scene(root, 300, 300, Color.TRANSPARENT));
            // EXPLICITLY INCLUDING THE RESIZE LOGIC !!!
            stg.getScene().addEventFilter(MouseEvent.ANY, new ResizeHandler(stg));
            stg.show();
        });

        VBox root = new VBox(button1, button2, button3, button4);
        root.setAlignment(Pos.CENTER);
        root.setSpacing(10);
        Scene sc = new Scene(root, 400, 400);
        stage.setScene(sc);
        stage.setTitle("Stage Styles Demo");
        stage.show();
    }

    private Node buildDraggableHeader() {
        BorderPane header = new BorderPane();
        header.setMinHeight(24);
        header.setRight(new HBox(new Button("-"), new Button("0"), new Button("X")));
        StackPane title = new StackPane(new Label("Draggable Header"));
        title.setStyle("-fx-font-weight:bold;");
        title.setAlignment(Pos.CENTER_LEFT);
        header.setLeft(title);
        header.setStyle("-fx-background-color:#999999;-fx-border-width: 0 0 2 0;-fx-border-color:#555555;");
        header.setPadding(new Insets(0, 0, 0, 3));

        // EXPLICITLY INCLUDING THE DRAG LOGIC !!!
        DoubleProperty x = new SimpleDoubleProperty();
        DoubleProperty y = new SimpleDoubleProperty();
        header.setOnMousePressed(e -> {
            x.set(e.getSceneX());
            y.set(e.getSceneY());
        });
        header.setOnMouseDragged(e -> {
            header.getScene().getWindow().setX(e.getScreenX() - x.get());
            header.getScene().getWindow().setY(e.getScreenY() - y.get());
        });

        return header;
    }

    /**
     * Handler to process the resizing of the the given stage.
     */
    class ResizeHandler implements EventHandler<MouseEvent> {

        /**
         * Space to consider around the stage border for resizing
         */
        private static final double BORDER = 6;

        /**
         * Space to consider the border width factor while resizing
         */
        private static final double BORDER_WIDTH_FACTOR = 6;

        private final Window window;
        /**
         * Current cursor reference to the scene
         */
        private Cursor cursor = Cursor.DEFAULT;

        /**
         * X position of the drag start
         */
        private double startX = 0;

        /**
         * Y position of the drag start
         */
        private double startY = 0;

        ResizeHandler(final Window window) {
            this.window = window;
        }

        @Override
        public void handle(final MouseEvent event) {
            final EventType<? extends MouseEvent> eventType = event.getEventType();
            final Scene scene = window.getScene();
            final double mouseEventX = event.getSceneX();
            final double mouseEventY = event.getSceneY();
            final double sceneWidth = scene.getWidth();
            final double sceneHeight = scene.getHeight();
            final boolean isResizable = true;

            if (isResizable) {
                if (MouseEvent.MOUSE_MOVED.equals(eventType)) {
                    assignCursor(scene, event, mouseEventX, mouseEventY, sceneWidth, sceneHeight);

                } else if (MouseEvent.MOUSE_PRESSED.equals(eventType)) {
                    startX = window.getWidth() - mouseEventX;
                    startY = window.getHeight() - mouseEventY;
                    consumeEventIfNotDefaultCursor(event);

                } else if (MouseEvent.MOUSE_DRAGGED.equals(eventType) && !Cursor.DEFAULT.equals(cursor)) {
                    consumeEventIfNotDefaultCursor(event);
                    if (!Cursor.W_RESIZE.equals(cursor) && !Cursor.E_RESIZE.equals(cursor)) {
                        handleHeightResize(event);
                    }

                    if (!Cursor.N_RESIZE.equals(cursor) && !Cursor.S_RESIZE.equals(cursor)) {
                        handleWidthResize(event);
                    }
                }
            }
        }

        private void assignCursor(final Scene scene, final MouseEvent event, final double mouseEventX,
                                  final double mouseEventY, final double sceneWidth, final double sceneHeight) {
            final Cursor cursor1;

            if (mouseEventX < BORDER && mouseEventY < BORDER) {
                cursor1 = Cursor.NW_RESIZE;
            } else if (mouseEventX < BORDER && mouseEventY > sceneHeight - BORDER) {
                cursor1 = Cursor.SW_RESIZE;
            } else if (mouseEventX > sceneWidth - BORDER
                    && mouseEventY < BORDER) {
                cursor1 = Cursor.NE_RESIZE;
            } else if (mouseEventX > sceneWidth - BORDER && mouseEventY > sceneHeight - BORDER) {
                cursor1 = Cursor.SE_RESIZE;
            } else if (mouseEventX < BORDER) {
                cursor1 = Cursor.W_RESIZE;
            } else if (mouseEventX > sceneWidth - BORDER) {
                cursor1 = Cursor.E_RESIZE;
            } else if (mouseEventY < BORDER) {
                cursor1 = Cursor.N_RESIZE;
            } else if (mouseEventY > sceneHeight - BORDER) {
                cursor1 = Cursor.S_RESIZE;
            } else {
                cursor1 = Cursor.DEFAULT;
            }
            cursor = cursor1;
            scene.setCursor(cursor);
        }

        /**
         * Consumes the mouse event if the cursor is not the DEFAULT cursor.
         *
         * @param event MouseEvent instance
         */
        private void consumeEventIfNotDefaultCursor(final MouseEvent event) {
            if (!cursor.equals(Cursor.DEFAULT)) {
                event.consume();
            }
        }

        /**
         * Processes the vertical drag movement and resizes the window height.
         *
         * @param event MouseEvent instance
         */
        private void handleHeightResize(final MouseEvent event) {
            final double mouseEventY = event.getSceneY();
            final double minHeight = 30;
            if (Cursor.NW_RESIZE.equals(cursor)
                    || Cursor.N_RESIZE.equals(cursor)
                    || Cursor.NE_RESIZE.equals(cursor)) {
                if (window.getHeight() > minHeight || mouseEventY < 0) {
                    final double newHeight = window.getY() - event.getScreenY() + window.getHeight();
                    window.setHeight(max(newHeight, minHeight));
                    window.setY(event.getScreenY());
                }
            } else if (window.getHeight() > minHeight || mouseEventY + startY - window.getHeight() > 0) {
                final double newHeight = mouseEventY + startY;
                window.setHeight(max(newHeight, minHeight));
            }
        }

        /**
         * Processes the horizontal drag movement and resizes the window width.
         *
         * @param event MouseEvent instance
         */
        private void handleWidthResize(final MouseEvent event) {
            final double mouseEventX = event.getSceneX();
            final double minWidth = 100;
            if (Cursor.NW_RESIZE.equals(cursor)
                    || Cursor.W_RESIZE.equals(cursor)
                    || Cursor.SW_RESIZE.equals(cursor)) {
                if (window.getWidth() > minWidth || mouseEventX < 0) {
                    final double newWidth = window.getX() - event.getScreenX() + window.getWidth();
                    window.setWidth(max(newWidth, minWidth));
                    window.setX(event.getScreenX());
                }
            } else if (window.getWidth() > minWidth || mouseEventX + startX - window.getWidth() > 0) {
                final double newWidth = mouseEventX + startX;
                window.setWidth(max(newWidth, minWidth));
            }
        }

        /**
         * Determines the max value among the provided two values.
         *
         * @param value1 First value
         * @param value2 Second value
         * @return Maximum value of the given two values.
         */
        private double max(final double value1, final double value2) {
            return value1 > value2 ? value1 : value2;
        }
    }


    public static void main(String... a) {
        Application.launch(a);
    }
}