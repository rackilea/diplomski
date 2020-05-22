/**
 * Facilitates an entire questionnaire
 */
public class Questionnaire extends ArrayList<Question> {

    /**
     * This questionnaire's name
     */
    private String name;

    /**
     * Creates a new questionnaire using the specified name
     * @param name  The name of this questionnaire
     */
    public Questionnaire(String name) {
        this.name = name;
    }

    /**
     * Returns the name of this questionnaire
     */
    public String getName() {
        return name;
    }
}