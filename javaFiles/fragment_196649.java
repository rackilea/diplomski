MediaPlayer player;
protected void onCreate(Bundle savedInstanceState)
{
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    player = MediaPlayer.create(MainActivity.this,R.raw.sadsadsad);
}