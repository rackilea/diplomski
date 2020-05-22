private String title;
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.your_activity);
    ...
    if(getIntent() != null) {
        title = getIntent().getStringExtra("TITLE_EXTRA")
    }
    ...
}