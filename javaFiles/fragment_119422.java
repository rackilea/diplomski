public Question find(Object id) {
    Question question = getEntityManager().find(Question.class, id);
    Hibernate.initialize(question.getCategories());
    Hibernate.initialize(question.getAnswers());
    Hibernate.initialize(question.getFeedback());

    return question ;
}