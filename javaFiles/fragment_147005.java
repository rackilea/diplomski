Public class MediaPlayerDemo_Video extends Activity implements TextureView.SurfaceTextureListener {


 private MediaPlayer mMediaPlayer;

 private TextureView mPreview;

 @Override
 public void onCreate(Bundle icicle) {

      super.onCreate(icicle);

      mPreview = new TextureView(this);
      mPreview.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
      mPreview.setSurfaceTextureListener(this);

      extras = getIntent().getExtras();

      setContentView(mPreview);
 }

 @Override
 public void onSurfaceTextureAvailable(SurfaceTexture surface, int width, int height) {
 Surface s = new Surface(surface);

 try {
       mMediaPlayer= new MediaPlayer();
       mMediaPlayer.setDataSource("http://daily3gp.com/vids/747.3gp");
       mMediaPlayer.setSurface(s);
       mMediaPlayer.prepare();
       mMediaPlayer.setOnBufferingUpdateListener(this);
       mMediaPlayer.setOnCompletionListener(this);
       mMediaPlayer.setOnPreparedListener(this);
       mMediaPlayer.setOnVideoSizeChangedListener(this);
       mMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
       mMediaPlayer.start();
      } catch (IllegalArgumentException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (SecurityException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (IllegalStateException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }   
}