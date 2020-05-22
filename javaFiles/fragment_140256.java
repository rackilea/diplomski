class MyObject {
    private String question;
    private String answer;

    // getters / setters / etc

    public void swap() {
        String temp = question; // store the question in a temp variable
        question = answer; // question now has the value of answer
        answer = temp; // answer now has the value of question
    }
}