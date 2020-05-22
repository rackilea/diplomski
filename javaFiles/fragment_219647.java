public class Song extends ActionBarActivity {
    TextView songcont;
    private SbDatabase mSongbook;


@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.song);

    Uri uri = getIntent().getData();
    Cursor cursor = managedQuery(uri, null, null, null, null);

    cursor.moveToFirst();        
    TextView songcont = (TextView) findViewById(R.id.songcont);
    songcont.setMovementMethod(new ScrollingMovementMethod());

    int wIndex = cursor.getColumnIndexOrThrow(SbDatabase.KEY_WORD);
    int dIndex = cursor.getColumnIndexOrThrow(SbDatabase.KEY_SONGCONT);

    String thetitle = (cursor.getString(wIndex));
    songcont.setText(cursor.getString(dIndex));
    setTitle(thetitle.replace("#", ""));

    Previous = (ImageButton)findViewById (R.id.imageButton1 );
    Previous.setOnClickListener(new OnClickListener() {

        public void onClick(View arg0) {
            Uri uri = getIntent().getData();
          Cursor cursor = managedQuery(uri, null, null, null, null);
          cursor.moveToFirst();                     
          int wIndex = cursor.getColumnIndexOrThrow(SbDatabase.KEY_WORD);               

          String Title = (cursor.getString(wIndex));        
          String[] strings = TextUtils.split(Title, "#");
          String MyTitle = strings[0].trim();
          int id = Integer.parseInt(MyTitle);

          Uri data = Uri.withAppendedPath(SbProvider.CONTENT_URI, String.valueOf(id-1));                
          Intent songIntent = new Intent(getApplicationContext(), Song.class);
          songIntent.setData(data);
          startActivity(songIntent);

        }

    });

    Next = (ImageButton)findViewById (R.id.imageButton2 ); 
    Next.setOnClickListener(new OnClickListener() {

        public void onClick(View arg0) {
            Uri uri = getIntent().getData();
          Cursor cursor = managedQuery(uri, null, null, null, null);
          cursor.moveToFirst();                     
          int wIndex = cursor.getColumnIndexOrThrow(SbDatabase.KEY_WORD);               

          String Title = (cursor.getString(wIndex));        
          String[] strings = TextUtils.split(Title, "#");
          String MyTitle = strings[0].trim();
          int id = Integer.parseInt(MyTitle);

          Uri data = Uri.withAppendedPath(SbProvider.CONTENT_URI, String.valueOf(id+1));                
          Intent songIntent = new Intent(getApplicationContext(), Song.class);
          songIntent.setData(data);
          startActivity(songIntent);

        }

    });

    detector = new SimpleGestureFilter(this,this);
}