String webUrl = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
         webUrl = getIntent().getExtras().getString("website");
        //..your code here...
   }