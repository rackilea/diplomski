public class RaidingAttack extends Activity {
    ArrayList<RaidingClass> raidingDetails = new ArrayList<RaidingClass>();
    RaidingAdapter raidingAdapter;

    MyDataBaseHelper dbHelper;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_raiding);
        //init dbHelper
        dbHelper = new MyDataBaseHelper(this);
        dbHelper.getReadableDatabase();