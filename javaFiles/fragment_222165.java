@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_news__details);

    Intent i = getIntent();
    String title = i.getStringExtra("title");
    String date = i.getStringExtra("date");
    int imageId = i.getIntExtra("image_id");
    String text = i.getStringExtra("text");
}