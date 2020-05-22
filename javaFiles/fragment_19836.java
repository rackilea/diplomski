public class MainActivity extends Activity implements View.OnClickListener {

private EditText userAnswer;
private TextView answerOutput;
private TextView scrambledWord;
private String word;
private String shuffledWord;
private Button button;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    scrambledWord = (TextView) findViewById(R.id.scrambledWord);
    userAnswer = (EditText) findViewById(R.id.answerInput);
    answerOutput = (TextView) findViewById(R.id.answerOutput); 
    createWord();
    button = (Button) findViewById(R.id.button);
    button.setOnClickListener(this);
}

private void createWord() {
    word = "Animals";
    ArrayList<Character> chars = new ArrayList<Character>(word.length()); // gets array with length of word
    for ( char c : word.toCharArray() ) {
        chars.add(c);
    }
    Collections.shuffle(chars); //shuffles the characters
    char[] shuffled = new char[chars.size()];
    for ( int i = 0; i < shuffled.length; i++ ) {
        shuffled[i] = chars.get(i);
    }
    shuffledWord = new String(shuffled);
    shuffledText.setText(shuffledWord);
}

@Override
public void OnClick(View v){
    if (word.equalsIgnoreCase(userAnswer.getText().toString())){
        answerOutput.setText("Correct!!");
    } else {
        answerOutput.setText("Sorry try again.");
    }
}