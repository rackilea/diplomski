public void onClick(View v) {

//Disable buttons
 for (int i = 0; i < answerGroup.length; i++) {
    for (int j = 0; j < answer.length; j++) {

         answerGroup[i].getChildAt(j).setEnabled(false);

     }
 }
 //put button colors

 for(RadioButton correct: correctAnswerRadios){
  correct.setTextColor(Color.GREEN);
 }

 for(RadioButton wrong: wrongAnswersRadios){
  wrong.setTextColor(Color.RED);
 }
}