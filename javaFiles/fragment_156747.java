public class AnotherClass implements Initializable {

    private static boolean firstTime = true;
    MediaPlayer mp3 = Main.mediaPlayer;

    @FXML
    private Button musicButton;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        if (firstTime)
        {
            mp3.statusProperty().addListener((o, oldVal, newVal) -> updateButton(newVal));
            firstTime = false;
        }
        updateButton(mp3.getStatus());
    }

    @FXML
    public void musicButtonClicked(ActionEvent e) throws IOException {
        switch(mp3.getStatus()) {
            case PLAYING:
                mp3.stop();
                break;
            default:
                mp3.play();
                break;
        }
    }

    private void updateButton(MediaPlayer.Status status)
    {
        switch(status) {
            case PLAYING:
                this.musicButton.setText("Stop Music");
                break;
            default:
                this.musicButton.setText("Play Music");
                break;
        }
    }
}