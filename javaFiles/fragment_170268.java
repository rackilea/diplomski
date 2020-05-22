private int SPEECH_REQUEST= 1000;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    boolean isFromWidget = false;
    Bundle extras = getIntent().getExtras();
    if(extras != null && extras.get("widget") != null)
    {
        isFromWidget = Boolean.valueOf(extras.get("widget").toString());
    }
    if(isFromWidget) {
        Intent voiceIntent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);

        voiceIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        voiceIntent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Speech recognition demo");
        voiceIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivityForResult(voiceIntent, SPEECH_REQUEST_CODE);
    }
}