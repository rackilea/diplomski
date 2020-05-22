public class MainActivity extends AppCompatActivity {

    EditText mCrimeTitle;
    EditText mCrimeDate;
    EditText mCrimeSuspect;
    CheckBox mCrimeSolved;

    Button mAddCrime;
    Button mDltCrime;
    ListView mCrimeList;

    CrimeDBHelper dbhlpr = new CrimeDBHelper(this);
    Cursor crimelist;
    SimpleCursorAdapter sca;

    long lastcrimeid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCrimeTitle = (EditText) findViewById(R.id.crimetitle);
        mCrimeDate = (EditText) findViewById(R.id.crimedate);
        mCrimeSuspect = (EditText) findViewById(R.id.crimesuspect);
        mCrimeSolved = (CheckBox) findViewById(R.id.crimesolved);
        mCrimeList = (ListView) findViewById(R.id.crimelist);
        mAddCrime = (Button) findViewById(R.id.addcrime);
        mDltCrime = (Button) findViewById(R.id.dltcrime);

        crimelist = dbhlpr.getCrimeList();

        // Setup Button to Add a crime
        mAddCrime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int solved = 0;
                if (mCrimeSolved.isChecked()) {
                    solved = 1;
                }
                lastcrimeid =  dbhlpr.addCrime(
                        mCrimeTitle.getText().toString(),
                        mCrimeDate.getText().toString(),
                        mCrimeSuspect.getText().toString(),
                        solved
                );
                mDltCrime.setText("DLT CRIME (ID=" + Long.toString(lastcrimeid) + ")");
                mDltCrime.setTag(lastcrimeid);
                crimelist = dbhlpr.getCrimeList();
                sca.swapCursor(crimelist);
            }
        });

        // Setup button to delete the latest Crime added
        mDltCrime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //dbhlpr.deleteCrime(lastcrimeid); can do it this way
                if (view.getTag() != null) {
                    dbhlpr.deleteCrime((long)view.getTag());
                    crimelist = dbhlpr.getCrimeList();
                    sca.swapCursor(crimelist);
                }
            }
        });

        sca = new SimpleCursorAdapter(this,
                android.R.layout.simple_list_item_1,
                crimelist,
                new String[]{CrimeDBHelper.CRIMETITLE_COL},
                new int[]{android.R.id.text1},
                0
        );
        mCrimeList.setAdapter(sca);

        mCrimeList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                dbhlpr.deleteCrime(l);
                crimelist = dbhlpr.getCrimeList();
                sca.swapCursor(crimelist);
                return true;
            }
        });

    }

    protected void onDestroy() {
        super.onDestroy();
        if (crimelist != null) {
            crimelist.close();
        }

    }
}