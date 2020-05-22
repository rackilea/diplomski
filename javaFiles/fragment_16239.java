public class AnswerConnector {
    private final IntegerProperty noOfAnswers = new SimpleIntegerProperty(0);

    public IntegerProperty noOfAnswersProperty() {
        return noOfAnswers;
    }

    public int getNoOfAnswers() {
        return noOfAnswers.get();
    }

    public void setNoOfAnswers(int noOfAnswers) {
        this.noOfAnswers.set(noOfAnswers);
    }

    // same for noOfQuestions
}