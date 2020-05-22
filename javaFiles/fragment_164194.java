public class ControllerSample {
    @FXML
    private TextArea textAreaSample;

    @FXML
    private ControllerSending sendingController;

    public ControllerSample() {
    }

    public TextArea getTextAreaSample() {
        return textAreaSample;
    }

    public void setTextAreaSample(TextArea textAreaSample) {
        this.textAreaSample = textAreaSample;
    }

    protected ControllerSending getSendingController() {
        return sendingController;
    }
}

public class ControllerSending {
    @FXML
    private ControllerSendingPhotos sendingPhotosController;

    public ControllerSending() {
    }

    protected ControllerSendingPhotos getSendingPhotosController() {
        return sendingPhotosController;
    }
}

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        FXMLLoader loaderSample = new FXMLLoader(getClass().getResource("sample.fxml"));

        Parent root = loaderSample.load();

        ControllerSample controllerSample = (ControllerSample) loaderSample.getController();

        TextArea textAreaSample = controllerSample.getTextAreaSample();
        textAreaSample.setText("\ndebug textAreaSample\n");

        TextArea textAreaSendingPhotos = controllerSample.getSendingController().getSendingPhotosController()
            .getTextAreaSendingPhotos();
        textAreaSendingPhotos.setText("test test test");

        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 800, 400));
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}