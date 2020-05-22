private final String[] title  = {"Male", "Female", "Other", "Secret"};
private RadioGroup radioGroup;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    linearLayout = (LinearLayout) findViewById(R.id.linear_layout);
    radioGroup = new RadioGroup(this);

    RadioButton radioButton;

    for (int i = 0; i < title.length; i++) {
        radioButton = new RadioButton(this);
        radioButton.setId(i);
        radioButton.setText(title[i]);
        radioGroup.addView(radioButton);
    }

    linearLayout.addView(radioGroup);
}

public void checkAnswer(View view) {
    //get the answer here
    int checkedId = radioGroup.getCheckedRadioButtonId();
    TextView answerText = (TextView) findViewById(R.id.answer);
    // Note: make sure there is a checked RadioButton! 
    answerText.setText("You selected the option..." + title[checkedId]);
}