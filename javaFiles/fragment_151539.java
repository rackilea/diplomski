public class MainActivity extends ActionBarActivity {

    private TextView textView;
    private int count = 1;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);
        handler.postDelayed(new Runnable() {

            @Override
            public void run() {
                textView.setText(count+"");
                count++;
                if (count > 3) {
                    handler.removeCallbacks(this);
                } else {
                    handler.postDelayed(this, 3000);    
                }
            }
        }, 0);
    }
}