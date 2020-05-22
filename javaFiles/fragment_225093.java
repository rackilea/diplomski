private static final String RADIOGROUP_TAG = "radiogroup";

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    linearLayout = (LinearLayout) findViewById(R.id.linear_layout);
    RadioGroup radioGroup = new RadioGroup(this);
    radioGroup.setTag(RADIOGROUP_TAG);

    RadioButton radioButton;

    final String[] title = {"Male", "Female", "Other", "Secret"};

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
    RadioGroup radioGroup = linearLayout.findViewWithTag(RADIOGROUP_TAG);
    int checkedId = radioGroup.getCheckedRadioButtonId();
    RadioButton radioButton = radioGroup.findViewById(checkedId);
    String text = radioButton.getText().toString();

    TextView answerText = (TextView) findViewById(R.id.answer);
    answerText.setText("You selected the option..." + text);
}