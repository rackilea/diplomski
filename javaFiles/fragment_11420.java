public static boolean isBlue, isRed, isYellow, isGreen;
public class MainActivity extends Activity {

    Button bluebutton, redbutton, yellowbutton, greenbutton;
    DrawRectangle dr;
    Canvas canvas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);

    dr = new DrawRectangle(this);

    bluebutton = (Button)findViewById(R.id.bluebutton);
    redbutton = (Button)findViewById(R.id.redbutton);
    yellowbutton = (Button)findViewById(R.id.yellowbutton);
    greenbutton = (Button)findViewById(R.id.greenbutton);

    boolean blueColor = false;
    bluebutton.setOnClickListener(new View.OnClickListener() {

    @Override
    public void onClick(View arg0) {
        // TODO Auto-generated method stub
        isBlue = true;
        isRed = false;
        isGreen = false;
        isYellow = false;
        dr.invalidate();
    }
    });
}