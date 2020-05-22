@Override
protected void onCreate(Bundle savedInstanceState)
{
    super.onCreate(savedInstanceState);
    setContentView(new Button(this));

    AACPlayer aacPlayer = new AACPlayer();
    aacPlayer.playAsync( "http://http.yourmuze.com:8000/play/paradise/h.aac" );
}