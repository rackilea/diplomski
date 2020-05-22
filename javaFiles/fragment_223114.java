public int displayQuestion(int playerNum)
{
        int questionNumber = getRandomQuestionNumber();
        // Display the player number.
        System.out.println("Question for player #" + playerNum);
        System.out.println("------------------------");

        // Display the question.
        System.out.println(getQuestion(questionNumber));
        System.out.println(getPossibleAnswers(questionNumber));
        return questionNumber;
}