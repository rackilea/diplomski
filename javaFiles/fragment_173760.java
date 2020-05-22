import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Random;

// java 8 code
public class RectangleAddition extends Application {
    private final Random random = new Random(42);

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage stage) {
        FlowPane   flow       = createItemContainer();
        ScrollPane scroll     = makeContainerScrollable(flow);
        ItemSource itemSource = new ItemSource();

        Button create = createItemControl(flow, scroll, itemSource);
        VBox layout   = createLayout(create, scroll);

        Scene scene = new Scene(layout);
        stage.setScene(scene);
        stage.show();
    }

    private FlowPane createItemContainer() {
        FlowPane flow = new FlowPane();
        flow.setHgap(5);
        flow.setVgap(5);

        return flow;
    }

    /**
     * The control will
     *   retrieve items from the source,
     *   add them to the scrollable pane,
     *   scroll the pane to the bottom on each addition.
     */
    private Button createItemControl(Pane flow, ScrollPane scroll, ItemSource itemSource) {
        Button create = new Button("Create Rectangles (keep pressing to create more)");

        create.setOnAction(event -> {
            addRectangles(flow, itemSource);
            scroll.setVvalue(scroll.getVmax());
        });

        return create;
    }

    private VBox createLayout(Button create, ScrollPane scroll) {
        VBox layout = new VBox(10, create, scroll);

        layout.setStyle("-fx-padding: 10px;");
        layout.setPrefSize(300, 300);
        VBox.setVgrow(scroll, Priority.ALWAYS);
        create.setMinHeight(Button.USE_PREF_SIZE);

        return layout;
    }

    /**
     * fetches some items from the source,
     * creates rectangle nodes for them
     * adds them to the container.
     */
    private void addRectangles(Pane container, ItemSource itemSource) {
        Queue<Item> items = itemSource.fetchNextItems();
        while (!items.isEmpty()) {
            Item item = items.remove();

            Node rectangle = createRectangle(item);
            container.getChildren().add(rectangle);
        }
    }

    private Rectangle createRectangle(Item item) {
        Rectangle rectangle = new Rectangle(item.size, item.size, item.color);
        rectangle.setRotate(item.rotation);

        return rectangle;
    }

    private ScrollPane makeContainerScrollable(FlowPane flow) {
        ScrollPane scroll = new ScrollPane(flow);
        scroll.setFitToWidth(true);
        scroll.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

        return scroll;
    }

    /** some model data for application items */
    class Item {
        // item will be colored according to rgb values from the (inclusive) range
        // MIN_COLOR_VALUE to MIN_COLOR_VALUE + COLOR_RANGE - 1
        private static final int MIN_COLOR_VALUE = 50;
        private static final int COLOR_RANGE = 201;

        // item will be sized from the (inclusive) range
        // MIN_SIZE to MIN_SIZE + SIZE_RANGE - 1
        private static final int MIN_SIZE = 5;
        private static final int SIZE_RANGE = 21;

        // item will be (z-axis) rotated from the (inclusive) range
        // - ROTATE_SCOPE to + ROTATE_SCOPE
        private static final int ROTATE_SCOPE = 10;

        private Color color;
        private int size;
        private int rotation;

        public Item() {
            color = Color.rgb(
                    createColorComponent(),
                    createColorComponent(),
                    createColorComponent()
            );

            size = random.nextInt(SIZE_RANGE) + MIN_SIZE;

            rotation = random.nextInt(ROTATE_SCOPE * 2 + 1) - ROTATE_SCOPE;
        }

        private int createColorComponent() {
            return random.nextInt(COLOR_RANGE) + MIN_COLOR_VALUE;
        }
    }

    /** a never-ending source of new items fetched in batches */
    class ItemSource {
        // will fetch between 1 and MAX_NUM_ITEMS_PER_FETCH (inclusive) items on each fetch call.
        private static final int MAX_NUM_ITEMS_PER_FETCH = 5;

        public Queue<Item> fetchNextItems() {
            int numItems = random.nextInt(MAX_NUM_ITEMS_PER_FETCH) + 1;

            Queue<Item> queue = new ArrayDeque<>(numItems);
            for (int i = 0; i < numItems; i++) {
                queue.add(new Item());
            }

            return queue;
        }
    }
}