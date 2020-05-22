public class Realtime extends TabActivity {
    TabHost tabHost;
    TabHost.TabSpec spec;
    Intent intent;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        tabHost = getTabHost();
        tabHost.getTabWidget().setDividerDrawable(R.drawable.tab_divider);

        makeTab("test");
    }