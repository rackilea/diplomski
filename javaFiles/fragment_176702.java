public class MainActivity extends AppCompatActivity {

    int androidAPILevel = android.os.Build.VERSION.SDK_INT;
    TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tts = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                start();
            }
        });
    }

    private void start() {
        if (androidAPILevel < 21) {
            HashMap<String,String> params = new HashMap<>();
            params.put(TextToSpeech.Engine.KEY_PARAM_VOLUME, "0.5"); // change the 0.5 to any value from 0-1 (1 is default)
            tts.speak("This is a volume test.", TextToSpeech.QUEUE_FLUSH, params);
        } else { // android API level is 21 or higher...
            Bundle params = new Bundle();
            params.putFloat(TextToSpeech.Engine.KEY_PARAM_VOLUME, 0.5f); // change the 0.5f to any value from 0f-1f (1f is default)
            tts.speak("This is a volume test.", TextToSpeech.QUEUE_FLUSH, params, null);
        }
    }
}