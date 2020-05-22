public class FancyScrollPane extends Application {

    @Override
    public void start(Stage primaryStage) {
        ScrollPane scrollPane = new ScrollPane();
        Pane content = new Pane();
        scrollPane.setContent(content);

        // adding background
        content.getChildren().add(new Rectangle(500, 500, Color.GREEN));

        Circle immovableObject = new Circle(30, Color.RED);
        content.getChildren().add(immovableObject);

        primaryStage.setScene(new Scene(scrollPane, 300, 300));
        primaryStage.show();

        // here we bind circle Y position
        immovableObject.layoutYProperty().bind(
                // to vertical scroll shift (which ranges from 0 to 1)
                scrollPane.vvalueProperty()
                    // multiplied by (scrollableAreaHeight - visibleViewportHeight)
                    .multiply(
                        content.heightProperty()
                            .subtract(
                                new ScrollPaneViewPortHeightBinding(scrollPane))));
    }

    // we need this class because Bounds object doesn't support binding 
    private static class ScrollPaneViewPortHeightBinding extends DoubleBinding {

        private final ScrollPane root;

        public ScrollPaneViewPortHeightBinding(ScrollPane root) {
            this.root = root;
            super.bind(root.viewportBoundsProperty());
        }

        @Override
        protected double computeValue() {
            return root.getViewportBounds().getHeight();
        }
    }

    public static void main(String[] args) { launch(); }
}