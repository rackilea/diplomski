@Entity
@Table
public class Answer {
  /* other stuff */
  @ManyToOne
  @JoinColumn(name = "question_id", insertable = false, updatable = false)
  private Question question;
}