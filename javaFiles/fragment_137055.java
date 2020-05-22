@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_register);
    //Initialize
    ButterKnife.bind(this);
    context = RegisterActivity.this;
    mAdapter = new CountryAdapter(models, context,this);

}