public class BackgroundMusicService extends Service {

    public static final String ACTION_START_MUSIC = "package_name.action_start_music";
    public static final String ACTION_STOP_MUSIC = "package_name.action_stop";

    private MediaPlayer player;

    public IBinder onBind(Intent arg0) {

        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        player = MediaPlayer.create(this, R.raw.game_music);
        player.setLooping(true);
        player.setVolume(10, 10);

    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        if(intent.getAction() != null){
            switch (intent.getAction()){
                case ACTION_START_MUSIC :
                    if(!player.isPlaying()){
                          player.start();
                    }
                    break;
                case ACTION_STOP_MUSIC :
                    if(player.isPlaying()) {
                         player.stop();
                    }
                    break;
                default: break;
            }
        }
        return START_STICKY;
    }



    @Override
    public void onDestroy() {
       player.release();
    }

    @Override
    public void onLowMemory() {

    }
}