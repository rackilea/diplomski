public class MainActivity extends AppCompatActivity {
    String message = "How may I help you?";
    String mostRecentUtteranceID;
    private TextToSpeech myTTS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myTTS = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(myTTS.getEngines().size() == 0){
                    Toast.makeText(MainActivity.this,"No Engines Installed",Toast.LENGTH_LONG).show();
                }else{
                    if (status == TextToSpeech.SUCCESS){
                        ttsInitialized();
                    }
                }
            }
        });
    }

    private void ttsInitialized() {

        // *** set UtteranceProgressListener AFTER tts is initialized ***
        myTTS.setOnUtteranceProgressListener(new UtteranceProgressListener() {
            @Override
            public void onStart(String utteranceId) {

            }

            @Override
            // this method will always called from a background thread.
            public void onDone(String utteranceId) {

                // only respond to the most recent utterance
                if (!utteranceId.equals(mostRecentUtteranceID)) { 
                    Log.i("XXX", "onDone() blocked: utterance ID mismatch.");
                    return; 
                } // else continue...

                boolean wasCalledFromBackgroundThread = (Thread.currentThread().getId() != 1);
                Log.i("XXX", "was onDone() called on a background thread? : " + wasCalledFromBackgroundThread);

                Log.i("XXX", "onDone working.");

                // for demonstration only... avoid references to 
                // MainActivity (unless you use a WeakReference)
                // inside the onDone() method, as it
                // can cause a memory leak.
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        // *** toast will not work if called from a background thread ***
                        Toast.makeText(MainActivity.this,"onDone working.",Toast.LENGTH_LONG).show();
                    }
                });
            }

            @Override
            public void onError(String utteranceId) {

            }
        });

        // set Language
        myTTS.setLanguage(Locale.US);

        // set unique utterance ID for each utterance
        mostRecentUtteranceID = (new Random().nextInt() % 9999999) + ""; // "" is String force

        // set params
        // *** this method will work for more devices: API 19+ ***
        HashMap<String, String> params = new HashMap<>();
        params.put(TextToSpeech.Engine.KEY_PARAM_UTTERANCE_ID, mostRecentUtteranceID);

        myTTS.speak(message,TextToSpeech.QUEUE_FLUSH,params);

    }

}