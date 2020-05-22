@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_ACTION_BAR_OVERLAY);
        setContentView(R.layout.activity_main);

        getActionBar().setBackgroundDrawable(
                getResources().getDrawable(R.drawable.ab_bg_black));
}