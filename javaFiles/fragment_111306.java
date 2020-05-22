protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String a[] = new String[4];

        playlist = findViewById(R.id.open_playlist_bt);
        album = findViewById(R.id.open_albumlist_bt);

        playlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(MainActivity.this, PlaylistActivity.class));
            }
        });

        album.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, AlbumsActivity.class));
            }
        });
    }