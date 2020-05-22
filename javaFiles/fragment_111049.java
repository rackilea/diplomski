import ...

public class TimerTabController {
    public static final int TIMER_HBOX_TEXTFIELD_INDEX = 1;
    public static final int TIMER_HBOX_STARTSTOP_BUTTON_INDEX = 2;

    @FXML
    private Tab timerTab;
    @FXML
    private HBox defaultTimerHBox;
    @FXML
    private TextField defaultTimerTextField;

    private Map<HBox, MyTimer> timers = new HashMap<>();

    private AnimationTimer timerTabAnimationTimer = new AnimationTimer() {
        @Override
        public void handle(long l) {
        //the GUI updates go here
            for (HBox hBox : timers.keySet()) {
                if (hBox.getChildren().get(TIMER_HBOX_TEXTFIELD_INDEX) instanceof TextField) {
                    TextField currentField = (TextField) hBox.getChildren().get(TIMER_HBOX_TEXTFIELD_INDEX);
                    currentField.setText(MyFormatter.longMillisecondsTimeToTimeString(
                            timers.get(hBox).getRemainingTime())
                                        );
                }
            }
        }
    };

    @FXML
    protected void initialize() {
        timers.put(defaultTimerHBox, new MyTimer());
    }

    @FXML
    void handleSelectionChanged() { //triggered by changing tab selection
        if (timerTab.isSelected()) {
            timerTabAnimationTimer.start();
        } else {
            timerTabAnimationTimer.stop();
        }
    }

    //some more code
}