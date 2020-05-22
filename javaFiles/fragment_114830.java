if (questionsObject.getCorrectAnswer().equals(answer.getText())) {
    Toast.makeText(getApplicationContext(), 
                   "Correct!", 
                   Toast.LENGTH_SHORT)
                  .show();
    score++;
}
else {
    Toast.makeText(getApplicationContext(), 
                   "Sorry! Better luck next time.", 
                   Toast.LENGTH_SHORT)
                   .show();
}