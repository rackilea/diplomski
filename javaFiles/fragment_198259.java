public class Question {

    // omitted for brevity

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
    private List<QuestionChoice> questionChoices;

    public void setQuestionChoices(List<QuestionChoice> questionChoices) {
        if (questionChoices != null) {
            questionChoices.forEach(choice -> choice.setQuestion(this));
        }
        this.questionChoices = questionChoices;
    }
}