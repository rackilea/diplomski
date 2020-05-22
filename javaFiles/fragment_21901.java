public class ZoomController extends ScrollPane {

    private int deltaCount = 0;
    private final double DEFAULT_ZOOM = 1.0;
    private DoubleProperty zoomMax = new SimpleDoubleProperty(10.0);
    private DoubleProperty zoomMin = new SimpleDoubleProperty(0.1);
    private DoubleProperty zoomDelta = new SimpleDoubleProperty(1.2);
    private DoubleProperty zoom = new SimpleDoubleProperty(DEFAULT_ZOOM);

    public ZoomController(Node content) {
        super(new Group(content));

        zoom.addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> ov, Number t, Number newZoom) {
                System.out.println("Zoom=" + newZoom.doubleValue());
                content.setScaleX(newZoom.doubleValue());
                content.setScaleY(newZoom.doubleValue());
            }
        });

        content.setOnScroll(new EventHandler<ScrollEvent>() {
            public void handle(ScrollEvent event) {
                if (event.getDeltaY() > 0) {
                    zoomIn();
                } else {
                    zoomOut();
                }
            }
        });
    }