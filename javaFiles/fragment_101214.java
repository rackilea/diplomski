class JustAGUIExample {
    private Label scoresLabel;
    private MyGameLogic gameLogic;
    private AudioClip levelUpAudio = new AudioClip("levelup.mp3");

    public JustAGUIExample() {
        scoresLabel.textProperty().bind(
            gameLogic.scoreProperty().asString()
        );

        gameLogic.scoreProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                levelUpAudio.play();
            }
        });
    }
}