@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main2);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    // setSupportActionBar(toolbar);
    toolbar.setTitle("Testing");
    toolbar.setTitleTextColor(ContextCompat.getColor(this, R.color.colorAccent));
    toolbar.inflateMenu(R.menu.menu_main);
    toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
        @Override
        public boolean onMenuItemClick(MenuItem item) {
            return false;
        }
    });
}