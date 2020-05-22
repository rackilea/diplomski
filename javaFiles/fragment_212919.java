private void updateQuestions(int num){
        question.setImageResource(mQuestions.getQuestion(num));
        question. setTag(mQuestions.getQuestion(num));
        choice_one.setImageResource(mQuestions.getChoice1(num));
        choice_one.setTag(mQuestions.getChoice1(num));
        choice_two.setImageResource(mQuestions.getChoice2(num));
        choice_two.setTag(mQuestions.getChoice2(num));
        choice_three.setImageResource(mQuestions.getChoice3(num));
        choice_three.setTag(mQuestions.getChoice3(num));
        choice_four.setImageResource(mQuestions.getChoice4(num));
        choice_four.setTag(mQuestions.getChoice4(num));

        mAnswer = mQuestions.getAnswer(num);
    }