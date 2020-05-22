import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.VideoView;

public class SplashActivity extends Activity {

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView(R.layout.activity_splash);

    VideoView videoView = (VideoView) findViewById(R.id.video_view);

    Uri videoUri = Uri.parse("android.resource://ir.ugstudio.playvideo/raw/video1");
    videoView.setVideoURI(videoUri);

    videoView.start();

    videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            startActivity(new Intent(SplashActivity.this, MainActivity.class));
        }
    });
}
}