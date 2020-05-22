import java.util.List;

class Question {

    private final String question;
    private final List<Answer> answers;
    private final String correctAnswer;

    Question(String question, List<Answer> answers, String correctAnswer) {
        this.question = question;
        this.answers = answers;
        this.correctAnswer = correctAnswer;
    }

    String getQuestion() {
        return question;
    }

    List<Answer> getAnswers() {
        return answers;
    }

    String getCorrectAnswer() {
        return correctAnswer;
    }
}