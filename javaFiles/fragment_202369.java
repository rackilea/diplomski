/**
 * Facilitates a question and its answers
 */
public class Question extends ArrayList<Answer> {

    /**
     * The question's text
     */
    private String text;

    /**
     * Constructs a new question using the specified text
     * @param text  The question's text
     */
    public Question(String text) {
        this.text = test;
    }

    /**
     * Returns this question's text
     */
    public String getText() {
        return text;
    }
}