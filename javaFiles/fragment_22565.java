private int medCategoryInt;
private String medCategoryString;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_second);

    medCategoryInt = getIntent().getIntExtra("category_int", 0);
    medCategoryString = getIntent().getStringExtra("category_string");
}