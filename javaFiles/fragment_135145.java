public class MainActivity extends AppCompatActivity {

    DBHelper mDBHlpr;
    Cursor mCsr;
    CsrAdapter mAdapter;
    ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = this.findViewById(R.id.lisview);
        mDBHlpr = new DBHelper(this);
        mDBHlpr.addRow("Test1");
        mDBHlpr.addRow("Test2");
        mDBHlpr.addRow("Test3");

        mCsr = mDBHlpr.getAllRows();
        mAdapter = new CsrAdapter(this,mCsr,0);
        mListView.setAdapter(mAdapter);
    }
}