public class MainActivity extends AppCompatActivity {

    TextView mMessage;
    DatabaseHelper mDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMessage = this.findViewById(R.id.message);
        mDB = new DatabaseHelper(this);
        addSomeTestingUsers();


        // Immediately start Login Activity
        Intent i = new Intent(MainActivity.this,LoginActivity.class);
        startActivity(i);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mMessage.setText("Welcome back");
    }

    private void addSomeTestingUsers() {
        if (DatabaseUtils.queryNumEntries(mDB.getWritableDatabase(),DatabaseHelper.TBL_USER) > 0) return;
        mDB.addUser("Fred","fred@fredmal.com","password");
        mDB.addUser("Mary","mary@mary.email.com","password");
    }
}