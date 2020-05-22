else{

}
Integer num1text = Integer.parseInt(number1text.getText().toString());
Integer num2text = Integer.parseInt(number2text.getText().toString());
Integer ans = num1text + num2text; // +, -, * or / depending

TextView answer = (TextView) findViewById(R.id.ans);
answer.setText("Answer:" + ans.toString());