public boolean EnterAnswer(Editable answerView){
   boolean result = false;

   String answer = answerView.getText().toString().trim();

   if(answer.equals("1")){
       result = true;
     }

   return result;
   }