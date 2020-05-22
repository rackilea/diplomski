View view = (View) event.getLocalState();
view.setVisibility(View.INVISIBLE);
TextView dropTarget = (TextView) v;
TextView dropped = (TextView) view;
String temp = "a";
if(temp.equals(view.getTag()){
   goToNextQuestion();
}else{
   guessedWrong()
}