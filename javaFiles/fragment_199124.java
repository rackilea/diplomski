public class MainActivity extends AppCompatActivity {

    DBHelper mDBHlpr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDBHlpr = new DBHelper(this);
        // Add Some scores
        mDBHlpr.addScore(1,112);
        mDBHlpr.addScore(1,123);
        mDBHlpr.addScore(1,144);
        mDBHlpr.addScore(2,212);
        mDBHlpr.addScore(2,190);
        mDBHlpr.addScore(2,300);
        mDBHlpr.addScore(3,234);
        mDBHlpr.addScore(3,134);
        mDBHlpr.addScore(3,122);
        mDBHlpr.addScore(4,100);
        mDBHlpr.addScore(4,111);
        mDBHlpr.addScore(4,114);

        // Get The min and max scores example 1
        Cursor csr = mDBHlpr.getMaxMinScores();
        if (csr.moveToFirst()) {
            int max_score = csr.getInt(csr.getColumnIndex(DBHelper.DERIVEDCOL_MAXSCORE));
            int min_score = csr.getInt(csr.getColumnIndex(DBHelper.DERIVEDCOl_MINSCORE));
            Log.d("SCORES",
                    "\n\tMaximum Score is " + String.valueOf(max_score) +
                            "\n\tMinimum Score is " + String.valueOf(min_score)
            );
        }

        //Alternative utilising the MaxMin object
        MaxMin mymaxmin =  mDBHlpr.getMaxAndMinScores();
        Log.d("SCORES",
                "\n\tMaximum Score is " + String.valueOf(mymaxmin.getMax()) +
                        "\n\tMinimum Score is " + String.valueOf(mymaxmin.getMin())
        );
    }
}