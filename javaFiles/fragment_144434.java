public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);

    Intent i = getIntent();
    final ArrayList<String> stringArrayListExtra = i.getStringArrayListExtra("hello");
}