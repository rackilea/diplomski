public class InitialActivity extends TabActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);

        TabHost th = getTabHost();
        th.addTab(th.newTabSpec("tab_1").setIndicator("Tab1").setContent(R.id.tab1));
        th.addTab(th.newTabSpec("tab_2").setIndicator("Tab2").setContent(R.id.tab2));
        th.addTab(th.newTabSpec("tab_3").setIndicator("Tab3").setContent(R.id.tab3));
    }
}