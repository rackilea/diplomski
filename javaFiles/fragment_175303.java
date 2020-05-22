protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    textView = findViewById(R.id.textView);
    BottomNavigationView bottomNav = findViewById(R.id.bottomNav);
    bottomNav.setNavigationItemSelectedListener(this);
}