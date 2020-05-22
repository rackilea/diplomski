public class CreatingNewText extends Application {
private int size;
private TextField enterText;
private Slider sizeSlider;
private Button button;

private Text selected;

public static void main(String[] args) {
    launch(args);
}

public void start(Stage primaryStage) {
    Pane root = new Pane();
    // Button for creating new text Object
    button = new Button("text");
    button.setLayoutX(200);

    // Slider for Size
    sizeSlider = new Slider(0, 255, 0);
    sizeSlider.setLayoutX(250);
    sizeSlider.setLayoutY(0);

    // TextField
    enterText = new TextField();

    // Button functionality
    button.setOnAction(e -> {
        Text text = new Text(150, 300, "Text");
        // Moving created text
        text.setOnMouseDragged(f -> {
            text.setX(f.getX());
            text.setY(f.getY());
        });
        text.setLayoutX(300);
        text.setLayoutY(300);
        text.setFont(Font.font("Phosphate"));

        text.textProperty().bind(enterText.textProperty());

        text.addEventHandler(MouseEvent.MOUSE_PRESSED, mouseEvent -> {

            if (selected != null) {
                selected.setFill(Color.BLACK);
            }

            selected = (Text) mouseEvent.getTarget();
            selected.setFill(Color.RED);

        });

        root.getChildren().addAll(text);
    });

    sizeSlider.valueProperty().addListener((ObservableValue<? extends Number> ov, Number curVal, Number newVal) -> {

            if (selected != null) {
            size = (int) sizeSlider.getValue();
            Font fontSize = Font.font(size);
            selected.setFont(fontSize);
        }
    });

    root.getChildren().addAll(button, sizeSlider, enterText);
    Scene scene = new Scene(root, 600, 600);
    primaryStage.setScene(scene);
    primaryStage.show();
}
}