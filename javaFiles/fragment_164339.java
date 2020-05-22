EditText text = (EditText) findViewById(R.id.Part2Question1);
String answer = text.getText().trim();

if(answer.equals("7"))
   {
    score++;
   }
else{
     // show some toast showing that answer is incorrect
   }