public class Main extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        SoundPlayer soundPlayer = new SoundPlayer(getClass().getResource("song.mp3"));
        soundPlayer.play();


        primaryStage.setTitle("duet by Aran Mohyeddin");

        GUI gui = new GUI(soundPlayer);

        primaryStage.setScene(gui.getMainMenu().getScene());
        primaryStage.show();
    }

}