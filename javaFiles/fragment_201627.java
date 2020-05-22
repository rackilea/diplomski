public class MainActivity extends Activity {
DrawerLayout mDrawerLayout;
ExpandableListView mDrawerList;
ExpandableListAdapter listAdapter;
List<String> listDataHeader;
HashMap<String, List<String>> listDataChild;
private ActionBar mActionBar;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    ->> Add these lines
    mActionBar = getActionBar();
    mActionBar.setHomeButtonEnabled(true);
mActionBar.setDisplayHomeAsUpEnabled(false);