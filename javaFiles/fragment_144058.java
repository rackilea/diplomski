public class PlayVideoActivity extends BaseActivity {

@BindView(R.id.videoPlayer)
JCVideoPlayerStandard mVideoPlayer;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    restoreFromIntent(getIntent());
}

@Override
public int getLayout() {
    return R.layout.activity_play_video;
}

//create intent for this activity with all the necessary params
public static Intent createIntent(Context context, String videoUrl) {
    Intent intent = new Intent(context, PlayVideoActivity.class);
    intent.putExtra(ValueConstants.VIDEO_URL, videoUrl);
    return intent;
}

// get video path from intent and play the video here
private void restoreFromIntent(Intent intent) {
    String videoPath = intent.getExtras().getString(ValueConstants.VIDEO_URL);
    mVideoPlayer.setUp(videoPath
            , JCVideoPlayerStandard.SCREEN_LAYOUT_LIST, "");
}

@Override
public void onBackPressed() {
    if (JCVideoPlayer.backPress()) {
        return;
    }
    super.onBackPressed();
}

@Override
protected void onPause() {
    super.onPause();
    JCVideoPlayer.releaseAllVideos();
}
}