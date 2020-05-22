public class HomeActivity extends AppCompatActivity {

    TextView mUserameTextView, mUseridTextView, mCoinsTextView, mGemsTextView;
    Button mAdd10Coins, mAdd10Gems,mDone;
    User mUser;
    long mUserid;
    Context mContext;
    DatabaseHelper mDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mContext = this;
        mDB = new DatabaseHelper(mContext);

        mUserameTextView = this.findViewById(R.id.username);
        mUseridTextView = this.findViewById(R.id.userid);
        mCoinsTextView = this.findViewById(R.id.coins);
        mGemsTextView = this.findViewById(R.id.gems);

        Intent i = this.getIntent();
        mUserid = i.getLongExtra(LoginActivity.INTENTKEY_USERID,-1);
        mUser = mDB.getUser(mUserid);
        refreshDisplay();
        initButtons();
    }

    private void initButtons() {
        mAdd10Coins = this.findViewById(R.id.add10coins);
        mAdd10Coins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDB.adjustCoinsAndOrGems(mUser,10,User.ADJUSTTYPE_ADD,0,User.ADJUSTTYPE_ADD);
                mUser = mDB.getUser(mUserid);
                refreshDisplay();
            }
        });
        mAdd10Gems = this.findViewById(R.id.add10gems);
        mAdd10Gems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDB.adjustCoinsAndOrGems(mUser,0, User.ADJUSTTYPE_ADD,10,User.ADJUSTTYPE_ADD);
                mUser = mDB.getUser(mUserid);
                refreshDisplay();
            }
        });

        mDone = this.findViewById(R.id.done);
        mDB = new DatabaseHelper(mContext);
        mDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void refreshDisplay() {
        mUseridTextView.setText(mUser.getId());
        mUserameTextView.setText(mUser.getName());
        mCoinsTextView.setText(String.valueOf(mUser.getCoins()));
        mGemsTextView.setText(String.valueOf(mUser.getGems()));
    }
}