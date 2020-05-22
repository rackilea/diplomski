int getScore(List<Integer> answers) {
    Integer[] correctAnswers = {3,2,1};
    int score = 0;
    for (int i = 0; i < 3; i++) 
        if (correnctAnswers[i].equals(answers.get(i)))
            score++;
    return score;
}