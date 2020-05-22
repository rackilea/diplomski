public class LabelRectangleTestController implements Initializable {

    @FXML
    private Label message;
    @FXML
    private Rectangle bubble;
    @FXML
    private StackPane pane;
    @FXML
    private TextArea textArea;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        textArea.setText("message");
        message.textProperty().bind(textArea.textProperty());

        message.widthProperty().addListener((observable, oldValue, newValue) -> {
            bubble.setWidth(newValue.intValue() + 10);
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    pane.requestLayout();
                }
            });
        });
        message.heightProperty().addListener((observable, oldValue, newValue) -> {
            bubble.setHeight(newValue.doubleValue() + 10);
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    pane.requestLayout();

                }
            });
        });

    }

}