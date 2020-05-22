public class HealthQuestionHandler extends QuestionHandler {

    private bool canHandle(String question) {
        return question.startsWith("How") && question.endsWith("Josh");
    }

    public void handle(String question) {
        if( canHandle(question) ) {
            String healthStatus = "I am fine";

            System.out.println(healthStatus);

        } else {
            super.successor.handle(question);
        }
    }
}

public class MotherQuestionHandler extends QuestionHandler {

    private bool canHandle(String question) {
        return question.startsWith("Who") && question.endsWith("Mother");
    }

    public void handle(String question) {
        if( canHandle(question) ) {
            String mother = "..."; //name

            System.out.println(mother);

        } else {
            super.successor.handle(question);
        }
    }
}