@Override
onBackPressed() {
   if (currentGame.hasPreviousQuestion()) {
      currentGame.loadPreviousQuestion();
      setQuestions();
   } else {
      // pass call back to super class to be handled
      super.onBackPressed();
   }
}