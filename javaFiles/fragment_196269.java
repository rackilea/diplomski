public class Question {
    private String question;
    private List<String> possibleAnswers;
    private String answer;

    public Question(String question, List<String> possibleAnswers, String answer) {
        this.question = question;
        this.answer = answer;

        // randomize things:
        this.possibleAnswers = new ArrayList<>(possibleAnswers);
        Collections.shuffle(this.possibleAnswers);
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getPossibleAnswers() {
        return possibleAnswers;
    }

    public String getAnswer() {
        return answer;
    }

    // test if String matches answer
    public boolean test(String possibleAnswer) {
        return answer.equals(possibleAnswer);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Q: ");
        sb.append(question);
        sb.append("; ");
        sb.append("A: ");
        sb.append(answer);
        sb.append("; ");
        sb.append(possibleAnswers);
        return sb.toString();
    }
}