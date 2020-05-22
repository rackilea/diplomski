int questionCounter;
 /**
 * Method to set the text for the question and answers from the current games
 * current question
 */
private void setQuestions() {
    questionCounter++;
    //set the question text from current question
    String question = Utility.capitalise(currentQ.getQuestion()) + "? " + questionCounter;
    TextView qText = (TextView) findViewById(R.id.question);   
    qText.setText(question + " " + questionCounter);

    //set the available options
    List<String> answers = currentQ.getQuestionOptions();
    TextView option1 = (TextView) findViewById(R.id.answer1);
    option1.setText(Utility.capitalise(answers.get(0)));

    TextView option2 = (TextView) findViewById(R.id.answer2);
    option2.setText(Utility.capitalise(answers.get(1)));

    TextView option3 = (TextView) findViewById(R.id.answer3);
    option3.setText(Utility.capitalise(answers.get(2)));

    TextView option4 = (TextView) findViewById(R.id.answer4);
    option4.setText(Utility.capitalise(answers.get(3)));
}