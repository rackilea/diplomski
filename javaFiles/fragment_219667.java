public class MainActivity extends TabActivity
    implements ActivityOne.FileNameProvider {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getTabHost().addTab(getTabHost().newTabSpec("tab1")
                .setContent(new Intent(this, ActivityOne.class)));
        getTabHost().addTab(getTabHost().newTabSpec("tab2")
                .setContent(new Intent(this, ActivityTwo.class)));
    }


    @Override
    public void onNewFileName(String filename) {
        LocalActivityManager activityManager = getLocalActivityManager();
        getTabHost().setCurrentTabByTag("tab2");
        ActivityTwo two = (ActivityTwo) activityManager.getActivity("tab2");
        two.setFileName(filename);
    }
}