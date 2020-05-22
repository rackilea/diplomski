public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        final AppCompatTextView mTextView = (AppCompatTextView) mToolbar.findViewById(R.id.tv_title);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mTextView.setTransitionName("SimpleTransition");
        }

        AppCompatButton mBtnNext = (AppCompatButton) findViewById(R.id.btnNext);
        mBtnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent secondActivity = new Intent(MainActivity.this, SecondActivity.class);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(MainActivity.this, mTextView, mTextView.getTransitionName());
                    startActivity(secondActivity, options.toBundle());
                } else {
                    startActivity(secondActivity);
                }
            }
        });
    }
}