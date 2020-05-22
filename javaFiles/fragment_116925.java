public class ObserverActivity extends Activity  implements Observer{
    com.talha.examples.PaintView paint1;
    private ActivityHolder paintHolder = ActivityHolder.getInstance();
    EditText editText1;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paintview);        
        paint1= (com.talha.examples.PaintView)findViewById(R.id.paint1);
        editText1= (EditText)findViewById(R.id.editText1);
        paintHolder.registerObserver(this);

    }

    @Override
    public void updateNewValue(String str) {        
        editText1.setText(str);
    }
}