public class MainActivity extends Activity implements OnClickListener {

    Button btnLeft, btnRight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* Left Button */
        btnLeft = (Button) findViewById(R.id.btnLeft);
        btnLeft.setOnTouchListener(this);

        /* Right button */
        btnRight = (Button) findViewById(R.id.btnRight);
        btnRight.setOnTouchListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == btnleft) {
            // do stuff for button left
        }
        if (v == btnRight) {
            // do stuff for button right
        }
    }
}