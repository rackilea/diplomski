/**
 * Facilitates an answer
 */
public class Answer {

    /**
     * The answer's text
     */
    private String text;

    /**
     * Whether or not this answer is correct
     */
    private boolean correct;

    /**
     * Constructs a new answer using the specified settings
     * @param text          The text of this answer
     * @param correct       Whether or not this answer is correct
     */
    public Answer(String text, boolean correct) {
        this.text = text;
        this.correct = correct;
    }

    /**
     * Returns this answer's text
     */
    public String getText() {
        return text;
    }

    /**
     * Whether or not this answer is correct
     */
    public boolean isCorrect() {
        return correct;
    }
}