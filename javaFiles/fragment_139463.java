@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);

btnSpotifyapp = (Button)findViewById(R.id.btnSpotifyApp);
btnScoresApp = (Button)findViewById(R.id.btnScoresApp);
btnLibraryApp = (Button)findViewById(R.id.btnLibraryApp);
btnBuildItBigger = (Button)findViewById(R.id.btnBuildItBigger);
btnXYZReader = (Button)findViewById(R.id.btnXYZReader);
btnCapstone = (Button)findViewById(R.id.btnCapstone);

btnSpotifyapp.setOnClickListener(this);
btnScoresApp.setOnClickListener(this);
btnLibraryApp.setOnClickListener(this);
btnBuildItBigger.setOnClickListener(this);
btnXYZReader.setOnClickListener(this);
btnCapstone.setOnClickListener(this);
}