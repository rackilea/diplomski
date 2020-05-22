if (mQuestionNumber < mQuestionLibrary.getQuestionCount())
                updateQuestion();
 else
      {
           Intent intent =  new Intent(QuizActivity.this,ScoreDisplay.class);
           intent.putExtra("score",mScore);
           startActivity(intent);
       }