public class MainActivity extends AppCompatActivity {

    DBHelperNoRowid mDBhlpr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDBhlpr = new DBHelperNoRowid(this);
        logInsertResult(2100L,"row 1");
        logInsertResult(-898765432,"row 2");
    }

    private void logInsertResult(long not_an_id, String text) {

        Log.d("INSERTRESULT","Insertion of a row returned " + String.valueOf(
                mDBhlpr.insertUsingConvenienceInsert(not_an_id,text)
        ));
    }
}