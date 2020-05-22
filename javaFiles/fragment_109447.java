public class MainActivity extends AppCompatActivity {
    int total = 0;
    FrameLayout layout1;// = (FrameLayout) findViewById(R.id.layout1);
    /** 
    * edittext1 is used under onTouch, so it must be final variable or class level variable.
    */
    EditText edittext1;// = (EditText) findViewById(R.id.edittext1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
        * findViewById() method must be called after setContentView() method
        */
        layout1 = (FrameLayout) findViewById(R.id.layout1);
        edittext1 = (EditText) findViewById(R.id.edittext1);

        layout1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                total++;
                edittext1.setText("터치한 횟수: " + String.valueOf(total));
                return true;
            }
        });
    }

    public void closeApp(View v) {
        finish();
        System.exit(0);
    }
}