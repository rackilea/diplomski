public class PlayActivity extends AppCompatActivity implements SurfaceHolder.Callback {
    private SurfaceHolder sh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //getResource is your AsyncTask
        //I will not post it here because it is not the problem we had
        getResource _gR = new attemptGetStream(p1, p2);
        _gR.execute();

        //initiate components
        SurfaceView sV = (SurfaceView) findViewById(R.id.main);
        assert null != sV : "Surface is null";
        sV.getHolder().addCallback(this);
    }

    @Override
    public void surfaceCreated(SurfaceHolder sHolder) {
        //this is the solution.
        //only assign holder to a variable but don’t initiate MediaPlayer here
        //because we don’t have resource paths yet
        //we will initiate MediaPlayer in postExecute method and
        //attach to this holder from there
        sh = sHolder;
    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {
        log("Surface changed");
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        log("Surface destroyed");
    }

    //this is our method called from onPostExecute() in our getResource AsyncTask
    public void play(String path){
        //here initiate the MediaPlayer and assign dataSource
        //attach the player to sh(which is our surface holder
        try{
            MediaPlayer mMediaPlayer = new MediaPlayer();
            mMediaPlayer.setDisplay(sh);//sh is the surface holder
            mMediaPlayer.setDataSource(getApplicationContext(), path);//path is what we got from onPostExecute method in AsyncTask

            mMediaPlayer.prepareAsync();//i use prepareAsync method here so it will not hog the phone
            mMediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    mP.start();
                }
            });
        }catch (Exception e){//use exception types as you like
            e.printStackTrace();
        }
    }


}