@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

    // Toolbar :: Transparent
    toolbar.setBackgroundColor(Color.TRANSPARENT);

    setSupportActionBar(toolbar);
    getSupportActionBar().setTitle("StackOverflow");
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    // Status bar :: Transparent
    Window window = this.getWindow();

    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
    {
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(Color.TRANSPARENT);
    }

    ...........
    .................. 
}