public class Test extends Activity implements TouchHelper {
    ...
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        ...
        touchReader = new TouchReader(textView);
        touchReader.setOnTouchListener(this);
        ...
    }
}