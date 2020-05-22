@Projection(name = "questionProjection", types = { Question.class }) 
public interface QuestionProjection {
    // Getters
}

@Projection(name = "examProjection", types = { Exam.class }) 
public interface ExamProjection {
    List<QuestionProjection> getQuestionList();

    // Other Getters
}