public class SampleController implements Initializable {

    @FXML
    private VBox vbox_slideview;

    private Timeline timeline;

    @FXML
    public void onMouseMove(MouseEvent e) {
        if (e.getSceneY() < 0.03 * JavaFXApplication110.instance.stage.getScene().getHeight()) {
            this.vbox_slideview.setVisible(true);
            if (timeline.getStatus().equals(Animation.Status.STOPPED)) {
                timeline.play();
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        vbox_slideview.layoutYProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
                System.out.println("y = " + arg0.getValue());
            }
        });

        timeline = TimelineBuilder.create().keyFrames(
                new KeyFrame(
                Duration.millis(300),
                new KeyValue(this.vbox_slideview.layoutYProperty(),
                0)))
                .build();
    }
}