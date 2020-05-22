public class TimerController {
    private final Timeline timer;

    private final ObjectProperty<java.time.Duration> timeLeft;

    @FXML private Label timeLabel;

    public TimerController() {
        timer = new Timeline();
        timer.getKeyFrames().add(new KeyFrame(Duration.seconds(1), ae -> updateTimer()));
        timer.setCycleCount(Timeline.INDEFINITE);

        timeLeft = new SimpleObjectProperty<>();
    }
    public void initialize() {
        timeLabel.textProperty().bind(Bindings.createStringBinding(() -> getTimeStringFromDuration(timeLeft.get()), timeLeft));
    }

    @FXML
    private void startTimer(ActionEvent ae) {
        timeLeft.set(Duration.ofMinutes(5)); // For example timer of 5 minutes
        timer.playFromStart();
    }

    private void updateTimer() {
        timeLeft.set(timeLeft.get().minusSeconds(1));
    }

    private static String getTimeStringFromDuration(Duration duration) {
        // Do the conversion here...
    }
}