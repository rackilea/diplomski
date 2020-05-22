public ClassWide extends BaseActivity{

    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wide_view);

        initiateMenuTabs(getActionBar());// here it will call the method from the parent (BaseActivity)
            .... ....