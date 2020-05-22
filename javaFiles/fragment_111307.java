@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String a[] = new String[4];

        ArrayList<String> albums = new ArrayList<>();
        albums.add("Umqele");
        albums.add("We are friends");
        albums.add("Isiphithiphiti");
        albums.add("Scorpion kings");
        albums.add("Red");
        albums.add("Different world");
        albums.add("Irue");
        albums.add("Dirty Computer");
        albums.add("Anti");
        albums.add("Love Girls");

        ArrayAdapter<String> albumsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, albums);

        ListView albumView = findViewById(R.id.album);

        albumView.setAdapter(albumsAdapter);

    }

    public void openPlasylistActivity(View view) {

        startActivity(new Intent(this, PlaylistActivity.class));
    }