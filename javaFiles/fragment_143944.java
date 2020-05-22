public abstract class QuestionHandler {
    protected QuestionHandler successor;

    public void setSuccessor(QuestionHandler successor) {
        this.successor = successor;
    }

    public abstract void handle(String question);
}