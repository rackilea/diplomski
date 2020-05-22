ArrayList<Question> mQuestionList = new ArrayList<Question>;
mQuestionsList = QuestionBank.getQuestions();
mQuestionList.add(new Question(ops1, choices1));

Intent intent = new Intent(SourceActivity.this, TargetActivity.class);
intent.putExtra("QuestionListExtra", mQuestionList);