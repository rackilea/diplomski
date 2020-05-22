public class MainActivity extends AppCompatActivity {


Random r = new Random();
int points1 = 0;
int value1, value2;
TextView Number1;
TextView Number2;
TextView Answer;
TextView displayPoints;
EditText Attempt;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Number1 = findViewById(R.id.number1);
    Number2 = findViewById(R.id.number2);
    Answer = findViewById(R.id.Answer);
    displayPoints = findViewById(R.id.points);
    Attempt = findViewById(R.id.Attempt);

    value1 = r.nextInt(12 - 1) + 1;             //1st randomized set of values
    value2 = r.nextInt(12 - 1) + 1;             // ^
    Number1.setText("" + value1);                            //assigns randomized values to textEdits
    Number2.setText("" + value2);                            // ^^

}

public void onSubmitCheck(View view) {
    reset();                                               //When button Submit is clicked

}       //^ ^ Issue starts here when we click "submit" - the code generates new random values before checking the old ones against the mathematical expression in line 50..
//..meaning the user is already answering to the SECOND question before even attempting the first one.

public void reset() {

    int userAnswer = Integer.parseInt(Attempt.getText().toString());    //compares inputted value to an answer from line 50
    if (userAnswer == value1 + value2) {                                    //LINE 50
        Answer.setText("Correct!");
        point();
        displayPoints.setText("" + points1);

    } else {
        Answer.setText("Wrong :( Answer was: " + (value1 + value2));
    }

    value1 = r.nextInt(12 - 1) + 1;            //Assigns 2nd randomized values
    value2 = r.nextInt(12 - 1) + 1;            // ^
    Number1.setText("" + value1);
    Number2.setText("" + value2);