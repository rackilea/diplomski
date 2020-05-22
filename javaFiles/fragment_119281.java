public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        AppCompatTextView mTextView = (AppCompatTextView) findViewById(R.id.tv_title);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mTextView.setTransitionName("SimpleTransition");
        }
    }
}