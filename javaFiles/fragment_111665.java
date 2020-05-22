private Button btnCalc;
private EditText question, answer;

@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);

    answer = (EditText) findViewById(R.id.answer);
    question = (EditText) findViewById(R.id.question);
    btnCalc = (Button) findViewById(R.id.btnCalc);
            // The OnClickListener here will be executed outside the "Create",
            // i.e., when you actually click on the button, which will give you
            // a chance to enter some values in the question edittext...
    btnCalc.setOnClickListener(new OnClickListener() {

        @Override
        public void onClick(View v) {
            double in = 0.0;
            try {
                String inputStr = question.getText().toString();

                // if you want to check it use
                if (!TextUtils.isEmpty(inputStr)) {
                    in = Double.parseDouble(inputStr);
                }
            } catch (NumberFormatException e) {
                // This should probably do something more useful? i.e. tell
                // the user what they've done wrong...
                Log.e("Android",
                        "Double throws a NumberFormatException if you enter text that is not a number");
            }

            double miles = in * 1.6;
            answer.setText(String.valueOf(miles));
        }
    });
}