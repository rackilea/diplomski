public class Text_entry extends Activity implements OnTouchListener{
    private Speech speech;

    public void onCreate(Bundled saved) {
        super.onCreate(saved);
        speech = new Speech(this);
    }
    public boolean onTouch(View v, MotionEvent event) {
        speech.changeText(toRead);
        speech.speak();
    }
}