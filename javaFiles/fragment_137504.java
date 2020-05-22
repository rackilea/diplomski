class Answer {

    private final String question;
    private final ClassType classType;
    // static constructors, help to work with this model
    public static Answer mageAnswer(String question) {
        return new Answer(question, ClassType.MAGE);
    }

    public static Answer wariorAnswer(String question) {
        return new Answer(question, ClassType.WARIOR);
    }

    private Answer(String question, ClassType classType) {
        this.question = question;
        this.classType = classType;
    }

    public ClassType getClassType() {
        return classType;
    }

    public String getQuestion() {
        return question;
    }
}