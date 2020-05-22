public class UnhandledQuestionHandler extends QuestionHandler {

    public void handle(String question) {
        throw new UnhandledQuestionException("question not recognized");
    }
}