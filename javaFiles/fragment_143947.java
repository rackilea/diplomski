public class QuestionHandlerFactory {
    public static QuestionHandler create() {
        //if you can have several variants of this handler combinations, this method shouldn't be static

        QuestionHandler healthQuestionHandler = new HealthQuestionHandler();
        QuestionHandler motherQuestionHandler = new MotherQuestionHandler();
        QuestionHandler unhandledQuestionHandler = new UnhandledQuestionHandler()'

        motherQuestionHandler.setSuccessor(unhandledQuestionHandler);
        healthQuestionHandler.setSuccessor(motherQuestionHandler);

        return healthQuestionHandler;
    }
}