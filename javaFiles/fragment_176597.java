class MainActivity extends Activity {
protected EditText textVoice;
Button button;
TextToVoice textToVoice;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.ln_dialog);
    textVoice = (EditText) findViewById(R.id.textVoice);
    button = (Button) findViewById(R.id.button);
    button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            textToVoice = new TextToVoice(MainActivity.this,textVoice.getText().toString());
            textToVoice.listenVoice();
        }
    });

}


public class TextToVoice extends MainActivity {
    String textString;
    Context context;

    public TextToVoice(Context c ,String s) {
        textString = s;
        context = c;
    }

    public void listenVoice() {
        makeVoice();
    }

    public void downloadVoice() {
    }

    public void makeVoice() {
        Toast.makeText(context, makeUrl(), Toast.LENGTH_SHORT).show();
    }

    private String makeUrl() {

        if (textString.contains(" ")) {
            textString = textString.replace(" ", "+");
        }
        return textString;
    }
}