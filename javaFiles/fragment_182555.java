String mTitle;

               String URL;
              static String KEY_CATEGORY = "category";
    // public static final String URL_Address=null;
            static final String KEY_TITLE = "categoryName";
            static final String KEY_NAME ="categoryId";
              static final String KEY_SUBCATE = "categoryId";
        public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.subcate);
        Bundle b = getIntent().getExtras();
     mTitle = b.getString(KEY_SUBCATE);

     URL = "http://api1.sfsfsffsf.com/dev/categories/?fields=&categoryid=" + mTitle +       "&access_token=bfb787a";
 TextView grandtotal = (TextView) findViewById(R.id.subcate);
   grandtotal.setText("Welcome ," + mTitle );