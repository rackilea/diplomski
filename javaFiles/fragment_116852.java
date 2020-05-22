public class MainActivity extends AppCompatActivity {

    DBHelperNoRowid mDBhlpr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDBhlpr = new DBHelperNoRowid(this);
        // Insert some rows into the table that is a rowid table
        logInsertResult(1,"row 1",false,false);
        logInsertResult(1,"row 1",false,false);
        logInsertResult(1,"row 1",false,false);
        logInsertResult(1,"row 1",false,false);
        logInsertResult(-1,"row 1",false,true);

        logInsertResult(2100L,"row 1",true,true); //<<<<<<<<<< WITHOUT

        logInsertResult(1,"row 1",false,false);
        logInsertResult(1,"row 1",false,false);
        logInsertResult(1,"row 1",false,false);

        logInsertResult(-898765432,"row 2",true,true); //<<<<<<<<<< WITHOUT

        logInsertResult(1,"row 1",false,false);
        logInsertResult(1,"row 1",false,false);
        logInsertResult(1,"row 1",false,false);
        logInsertResult(1,"row 1",false,false);

        logInsertResult(-1L,"3rd row",true,true); //<<<<<<<<<< WITHOUT
    }

    private void logInsertResult(long no_an_id, String text, boolean without_rowid, boolean generate_rowid) {

        if (without_rowid) {
            Log.d("INSERTRESULT",">>>>>>>>>> WITHOUT ROWID ATTEMPT");
        }

        Log.d("INSERTRESULT","Insertion of a row returned " + String.valueOf(
                mDBhlpr.insertUsingConvenienceInsert(no_an_id,text,without_rowid,generate_rowid)
        ));
        mDBhlpr.logLastInsertId(); //
    }
}