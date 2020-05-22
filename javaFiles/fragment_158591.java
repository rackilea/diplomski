private EditText myInput;
private TextView text2;

public void onCreate(Bundle b) {
    super.onCreate(b);
    setContentView(...);
    ...

    myInput = (EditText) findViewById(R.id.myInput);
    text2 = (TextView) findViewById(R.id.text2);
} 

public void clickMe (View view) {
    String input = myInput.getText().toString();
    int number = 0;
    if (!input.isEmpty()) {
        number = Integer.parseInt(input);
    }
    // Sum the digits in a number
    int sum = 0;
    while (number > 0) {
        sum += number % 10;
        number = number / 10;
    }
    text2.setText(String.valueOf(sum));
}