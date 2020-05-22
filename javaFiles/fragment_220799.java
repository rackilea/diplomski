public void no (View view){
    EditText editTextOne = (EditText) findViewById(R.id.textView);
    EditText editTextTwo = (EditText) findViewById(R.id.textView1);
    int firstNumber = Integer.parseInt(editTextOne.getText().toString());
    int secondNumber = Integer.parseInt(editTextTwo.getText().toString());
    int sum = firstNumber + secondNumber;
    // Now send the result sum to the Activity B through intent.
    Intent intent = new Intent(this, Main2Activity.class);
    intent.putExtra("RESULT_SUM", sum);

    //add extra flag
    intent.putExtra("FROM_NO", true);
    startActivity(intent);


}

public void yes (View view){
    EditText editTextOned = (EditText) findViewById(R.id.resultno);
    EditText editTextTwod = (EditText) findViewById(R.id.textView);
    int firstNumberd = Integer.parseInt(editTextOned.getText().toString());
    int secondNumberd = Integer.parseInt(editTextTwod.getText().toString());
    int sumd = firstNumberd + secondNumberd;
    // Now send the result sum to the Activity B through intent.
    Intent intent = new Intent(this, Main2Activity.class);
    intent.putExtra("RESULT_SUMd", sumd);
    startActivity(intent);


}}