ImageButton ImageButton3;
TextView TextView26;
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    ImageButton3 = (ImageButton) findViewById(R.id.myImgBtnId);
    TextView26 = (TextView) findViewById(R.id.myTvId);

    ImageButton3.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {

            TextView26.text="";
        }
    });