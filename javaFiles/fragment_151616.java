public class MainActivity extends AppCompatActivity {

    private TextView mLowLabel, mMidLabel, mHighLabel;
    private BarView mLowBar, mMidBar, mHighBar;

    //Some sample percentage values
    private final int low = 17;
    private final int mid = 90;
    private final int high = 34;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLowBar = (BarView) findViewById(R.id.low_bar);
        mMidBar = (BarView) findViewById(R.id.mid_bar);
        mHighBar = (BarView) findViewById(R.id.high_bar);

        mLowLabel = (TextView) findViewById(R.id.low_text);
        mMidLabel = (TextView) findViewById(R.id.mid_text);
        mHighLabel = (TextView) findViewById(R.id.high_text);

        mLowBar.set(Color.BLUE, low);
        mMidBar.set(Color.RED, mid);
        mHighBar.set(Color.GREEN, high);

        mLowLabel.setText(getPercentage(low));
        mMidLabel.setText(getPercentage(mid));
        mHighLabel.setText(getPercentage(high));

    }

    private String getPercentage(int per) {
        return per + "%";
    }

}