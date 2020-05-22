public class QuizResult {
    private QuizType quizType;
    private double score;

    public QuizResult(QuizType quizType, double score) {
        this.quizType = quizType;
        this.score = score;
    }

    public QuizType getQuizType() {
        return quizType;
    }

    public void setQuizType(QuizType quizType) {
        this.quizType = quizType;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}