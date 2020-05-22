public void addQuestion(Question q) {
    switch (q.getDifficulty()) {
    case EASY:
        easyQuestions.add(q);
        break;
    case MEDIUM:
        mediumQuestions.add(q);
        break;
    case HARD:
        hardQuestions.add(q);
    }
}