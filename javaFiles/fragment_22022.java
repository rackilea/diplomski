public class Question {
    private String question;
    private String answer;
    private Difficulty difficulty;

    public Question(String question, String answer, Difficulty difficulty) {
        this.question = question;
        this.answer = answer;
        this.difficulty = difficulty;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

}