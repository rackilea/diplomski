// Iterate over the third to fifth question
for (int questionIndex = 2; questionIndex < 5; questionIndex ++) {
    // Get the current question
    Question question = questionnaire.get(questionIndex);

    // Iterate over all of the answers
    for (int answerIndex = 0; answerIndex < question.size(); answerIndex++) {
        // Get the current answer
        Answer answer = question.get(answerIndex);
    }
}