@Entity
public class Question {
  /* other stuff */
  @OneToMany
  @JoinColumn(name = "QUESTION_ID")
  @OrderColumn(name = "order")
  private List<Answer> answers;

  /* utility method for adding an answer to question */
  public void addAnswer(Answer answer) {
    if(answers == null)
      answers = new ArrayList<>();
    answer.getId().setQuestionId(this.id);
    answers.add(answer);
  }

}