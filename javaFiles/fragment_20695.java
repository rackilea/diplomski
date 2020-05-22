int answer = 0;
EditText secondQuestion = (EditText) findViewById(R.id.second_question);

if(secondQuestion.getText().toString().equals("")) { 
   //Handle invalid input
} else {
   answer = Integer.parseInt(secondQuestion.getText().toString());
}