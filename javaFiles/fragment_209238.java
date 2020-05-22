Intent intent = getIntent();
            Bundle extras = intent.getExtras();
            if (extras != null){
                if(extras.containsKey("quizNumber")) {



                           intValue=getIntent().getExtras().getInt("quizNumber")

                    }
                }

    updateQuestion(true,intValue);

or

     updateQuestion(false,intValue);



 private void updateQuestion(boolean forward, int intValue) {
            animateAnswerButton();
// also print toast of int value for checking value
            if(forward && mQuestionNumber < intValue //using mQuestion.getLength() works for looping full length of array but i want to check against int data)
                mQuestionNumber++;
            else if (mQuestionNumber>0)
                mQuestionNumber--;
            mQuestionText.setText(mQuestionLibrary.getQuestion(mQuestionNumber));
        }