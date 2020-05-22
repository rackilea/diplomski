public class MainActivity extends AppCompatActivity {

    public static final int DBVERSION = 1;
    public static final String DBNAME1 = "openassetdb.db";
    public static final int DB1_INDEX = 0;
    public static final String DBNAME2 = "myshopping";
    public static final int DB2_INDEX = 1;

    OpenAssetDBHelper mOADBHlpr;
    OpenAssetDBHelper mShoppingHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Example 1 - Database file located in the assets folder and
        //              database name same as file name
        mOADBHlpr = OpenAssetDBHelper.getInstance(DB1_INDEX,
                this,
                DBNAME1,
                DBVERSION,
                DBNAME1,
                null
        );
        // Example 2 - Database file in databases directory of the assets folder
        //              database name different to the asset filename
        mShoppingHelper = OpenAssetDBHelper.getInstance(DB2_INDEX,
                this,
                DBNAME2,
                DBVERSION,
                "shopper",
                new String[]{"databases"}
                );
    }
}