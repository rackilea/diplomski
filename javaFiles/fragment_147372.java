@Override
public void setContentView(int layoutResID) {
    DrawerLayout fullView = (DrawerLayout) getLayoutInflater().inflate(R.layout.activity_base, null);
    FrameLayout activityContainer = (FrameLayout) fullView.findViewById(R.id.activity_content);
    getLayoutInflater().inflate(layoutResID, activityContainer, true);
    super.setContentView(fullView);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
    setTitle("Activity Title");
}