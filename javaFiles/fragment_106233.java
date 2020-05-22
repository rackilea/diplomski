for (Answer answer : answers) {
    if (question == answer.getQuestion() && choice == answer.getChoice()) {
        return answer.isCorrect();
    }
}
throw new IllegalStateException("Choice not found???");