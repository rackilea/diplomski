TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView= (TextView) findViewById(R.id.textView1);

    }

    public void onYesButtonClick(View view){
       textView.setVisibility(android.view.View.VISIBLE);
  }