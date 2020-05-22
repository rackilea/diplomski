String answer = inputAnswer.getText();
boolean isCorrect = false;
for (String city : provinces) {
    if (answer.equalsIgnoreCase(city)) {
        outputDegree.setText("Correct");
        nextQuestion.setEnabled(true);
        isCorrect = true;
        break; // stops the loop if answer is correct
    }
}
if (!isCorrect) { //if there were no correct answers
    outputDegree.setText("Incorrect, try again!!");
     nextQuestion.setEnabled(false);
}