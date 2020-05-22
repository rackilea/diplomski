for (int i = 0; i < correctAnswer.length; i++) {
    int correctAnswers = 0;
    System.out.print("number of correct answers to question number " + i + ": ");

    for (int j = 0; j < studentAnswers.length; j++) {
        if (correctAnswer[i] == studentAnswers[j][i]) {
            correctAnswers = correctAnswers + 1;
        }
    }
    System.out.println(correctAnswers);
}