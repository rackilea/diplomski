public class Speech implements TextToSpeech.OnInitListener {
    private Context mContext;
    private TextToSpeech tts;

    public Speech(Context c) {
        mContext = c;
        tts = new TextToSpeech(c, this);
    }

    // Rest of class
}