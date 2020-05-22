// Iterate over the questions within the questionnaire
for(Question question : questionnaire) {
    // Print the question's text
    System.out.println(question.getText());

    // Go over each answer in this question
    for(Answer answer : question) {
        // Print the question's text
        System.out.println(answer.getText());
    }
}