public class MainActivity extends AppCompatActivity {

    DbHelper vDBHlpr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vDBHlpr = new DbHelper(this);
        List<Lyric> mylyricslist =  vDBHlpr.getAllSong();
        for (Lyric l: mylyricslist) {
            Log.d("LYRICFROMDB","Song is " + l.getSong() + " Year is " + l.getYear() + " Artist is " + l.getArtist() + " Genre is " + l.getGenre() + " Lyrics are " + l.getLyrics());
        }
    }
}