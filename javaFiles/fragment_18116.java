@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    AnswerA_ID = (RadioButton) findViewById(R.id.AnswerA);
    AnswerB_ID = (RadioButton) findViewById(R.id.AnswerB);
    AnswerC_ID = (RadioButton) findViewById(R.id.AnswerC);
    AnswerD_ID = (RadioButton) findViewById(R.id.AnswerD);
}