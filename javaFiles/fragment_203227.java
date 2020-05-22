public class Answer {
   @JoinColumn(name = "question_id")
   @ManyToOne(targetEntity = Question.class, fetch = FetchType.LAZY)
   private Question question;

   @Column(name = "question_id", insertable = false, updatable = false)
   private Long questionId;
}