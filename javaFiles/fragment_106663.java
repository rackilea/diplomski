public class Answer {
  public void linkQuestion(Question question) { 
    getId().setQuestionId(question.getId());
    this.question = question;
  }
}