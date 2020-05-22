public void onCreate(Bundle savedInstanceState){
    super.onCreate(savedInstanceState);
    setContentView(R.layout.layout2);

    Bundle args = getIntent().getExtras();
    String example = args.getString("myString");
    Log.e("Mytag", "here " + example);
}