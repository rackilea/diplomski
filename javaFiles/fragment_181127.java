public class MainActivity extends Activity {

    private MediaPlayer mp;
    private int playlistPos = 0;
    private List<Uri> playlist;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        playlist = createPlaylist();
        mp = new MediaPlayer();
        initMediaPlayer();
        initSong();
    }


    private void initMediaPlayer() {
        mp.setOnCompletionListener(new OnCompletionListener() {

            @Override
            public void onCompletion(MediaPlayer mp) {
                playlistPos++;

                if (playlistPos == playlist.size()) {
                    playlistPos = 0;
                }

                initSong();
            }
        });

        mp.setOnPreparedListener(new OnPreparedListener() {

            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.start();
            }
        });
    }


    private void initSong() {
        mp.reset();
        try {
            mp.setDataSource(this, playlist.get(playlistPos));
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        mp.prepareAsync();
    }


    private List<Uri> createPlaylist() {
        List<Uri> myUris = new ArrayList<Uri>();
        myUris.add(Uri.parse("https://db.tt/4ANlGRms"));
        myUris.add(Uri.parse("https://db.tt/TpmxsqGJ"));
        myUris.add(Uri.parse("https://db.tt/rbkYtuNI"));
        myUris.add(Uri.parse("https://db.tt/JYVHp9nm"));
        myUris.add(Uri.parse("https://db.tt/xWLATUQp"));
        myUris.add(Uri.parse("https://db.tt/WzV2TzFu"));
        return myUris;
    }

}