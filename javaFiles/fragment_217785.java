import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class MediaFX extends Application {

    MediaPlayer mediaplayer;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Media hello = new Media(this.getClass().getResource("one.wav").toExternalForm());
        Media meow = new Media(this.getClass().getResource("two.wav").toExternalForm());
        Media neww = new Media(this.getClass().getResource("three.wav").toExternalForm());

        ObservableList<Media> mediaList = FXCollections.observableArrayList();
        mediaList.addAll(hello, meow, neww);

        playMediaTracks(mediaList);

        VBox root = new VBox();

        stage.setScene(new Scene(root,300,300));
        stage.show();
    }

    private void playMediaTracks(ObservableList<Media> mediaList) {
        if (mediaList.size() == 0)
            return;

        MediaPlayer mediaplayer = new MediaPlayer(mediaList.remove(0));
        mediaplayer.play();

        mediaplayer.setOnEndOfMedia(new Runnable() {
            @Override
            public void run() {
                playMediaTracks(mediaList);
            }
        });
    }

}