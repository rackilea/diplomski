public abstract class MainActivity extends Activity {

    /*
     * Bundle keys specifying if the new activity inheriting from MainActivity
     * has a left and/or right navigation drawer.
     */
    public static final String KEY_MAIN_BUNDLE = "com.smashingboxes.bevii.MAIN_BUNDLE_KEY";
    public static final String KEY_HAS_RIGHT_DRAWER = "com.smashingboxes.bevii.HAS_RIGHT_DRAWER";
    public static final String KEY_HAS_LEFT_DRAWER = "com.smashingboxes.bevii.HAS_LEFT_DRAWER";
    public static final String KEY_LAYOUT_ID = "com.smashingboxes.bevii.LAYOUT_ID_KEY";
    public static final String KEY_SECTION_TITLE = "comm.smashingboxes.bevii.SECTION_TITLE";

    /*
     * Boolean indicators for each activity specifying their active navigation
     * drawers.
     */
    private boolean hasRightDrawer;
    private boolean hasLeftDrawer;

    /* The current activity's layout id for setContentView */
    private String sectionTitle;
    private int contentID;

    /* UI Elements */
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;

    /* Reference to the ActionBar title to toggle text on drawer changes. */
    protected CustomTextView mTitle;

    private ListView mDrawerListLeft;
    private LeftNavigationAdapter leftAdapter;
    private ListView mDrawerListRight;
    private LeftMessagesAdapter rightAdapter;

    /**
     * Handles the navigation drawer set up for each class inheriting from main
     * activity. A bundle must be specified indicating the number of navigation
     * drawers present in the activity's UI.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!getIntent().hasExtra(KEY_MAIN_BUNDLE))
            throw new IllegalArgumentException(
                    "Cannot access a subclass of MainActivity without including a main bundle.");

        Bundle mainBundle = getIntent().getBundleExtra(KEY_MAIN_BUNDLE);
        hasRightDrawer = mainBundle.getBoolean(KEY_HAS_RIGHT_DRAWER);
        hasLeftDrawer = mainBundle.getBoolean(KEY_HAS_LEFT_DRAWER);
        contentID = mainBundle.getInt(KEY_LAYOUT_ID);
        sectionTitle = mainBundle.getString(KEY_SECTION_TITLE);

        setContentView(contentID);

        if (hasRightDrawer && hasLeftDrawer) {
            handleLeftNavigationDrawer();
            handleRightNavigationDrawer();
        } else if (hasLeftDrawer) {
            handleLeftNavigationDrawer();
        } 
    }