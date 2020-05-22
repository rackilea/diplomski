public class MainActivity extends AppCompatActivity {

    DBAdapter mDBAdapter;
    Cursor mCsr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDBAdapter = new DBAdapter(this);
        addSomeData();

        mCsr = mDBAdapter.getAllAsCursor();
        while (mCsr.moveToNext()) {
            Log.d("BILLDATA",
                    "Title="+mCsr.getString(mCsr.getColumnIndex(DBAdapter.KEY_TITLE)) +
                            " Due Date=" + mCsr.getString(mCsr.getColumnIndex(DBAdapter.KEY_DUEDATE)) +
                            " Course=" + mCsr.getString(mCsr.getColumnIndex(DBAdapter.KEY_COURSE))
            );
        }
        mCsr.close();
    }

    // Add some data (note will add 3 rows each time it is run)
    private void addSomeData() {
        mDBAdapter.insertRecord("Bill1","2018-10-02","English");
        mDBAdapter.insertRecord("Bill2","2018-09-03","Mathematics");
        mDBAdapter.insertRecord("Bill3","2018-11-04", "Geography");
    }
}