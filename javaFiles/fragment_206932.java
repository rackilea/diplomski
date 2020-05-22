public class ArtistsActivity1 extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main1);
      }
}

public class ArtistsActivity2 extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main2);
      }
}


intent1 = new Intent().setClass(this, ArtistsActivity1.class);
spec = tabHost.newTabSpec("artists").setIndicator("Artists",
                  res.getDrawable(R.drawable.ic_tab_artists))
              .setContent(intent1);
tabHost.addTab(spec);

intent2 = new Intent().setClass(this, AlbumsActivity2.class);
spec = tabHost.newTabSpec("albums").setIndicator("Albums",
                  res.getDrawable(R.drawable.ic_tab_albums))
              .setContent(intent2);
tabHost.addTab(spec)