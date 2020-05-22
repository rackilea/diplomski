public class QuestionDTO {

    private int question_id;
    private String questionName;
    private String questionText;

    // notice that here you're using composition of DTOs (QuestionChoiceDTO instead of QuestionChoice)
    private List<QuestionChoiceDTO> questionChoices;

    // constructors..

    // getters and setters..
}