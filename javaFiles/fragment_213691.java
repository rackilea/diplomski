public class MainActivity extends TabActivity {
    private TabHost mTabHost;

    private void setupTabHost() {
    mTabHost = (TabHost) findViewById(android.R.id.tabhost);
    mTabHost.setup();
    }

    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.home);

    setupTabHost();
    mTabHost.getTabWidget().setDividerDrawable(R.drawable.item_seperator);

    setupTab(new TextView(this), "Month");
    setupTab(new TextView(this), "Week");
    setupTab(new TextView(this), "Day");

    final View view = new Button(this);

    View tabview = LayoutInflater.from(this).inflate(
        R.layout.button_tabs_bg, null);
    Button button = (Button) tabview.findViewById(R.id.tabsButton);
    button.setOnClickListener(new OnClickListener() {

        @Override
        public void onClick(View v) {
        Toast.makeText(MainActivity.this, "Button click",
            Toast.LENGTH_SHORT).show();
        }
    });

    TabSpec setContent = mTabHost.newTabSpec("").setIndicator(tabview)
        .setContent(new TabContentFactory() {
            public View createTabContent(String tag) {

            return view;
            }
        });

    mTabHost.addTab(setContent);

    mTabHost.getTabWidget().getChildTabViewAt(3).setEnabled(false);

    }

    private void setupTab(final View view, final String tag) {
    View tabview = createTabView(mTabHost.getContext(), tag);

    TabSpec setContent = mTabHost.newTabSpec(tag).setIndicator(tabview)
        .setContent(new TabContentFactory() {
            public View createTabContent(String tag) {
            return view;
            }
        });

    mTabHost.addTab(setContent);
    }

    private static View createTabView(final Context context, final String text) {
    View view = LayoutInflater.from(context)
        .inflate(R.layout.tabs_bg, null);
    TextView tv = (TextView) view.findViewById(R.id.tabsText);
    tv.setText(text);
    return view;
    }
}