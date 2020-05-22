private QuestionDetails getQuestionDetails(int questionId,
        List<QuestionDetails> questionsList) {
    /* Search Existing Object */
    for (QuestionDetails qd : questionsList) {
        /* Match Found */
        if (qd.getQuestionId() == questionId) {
            return qd;
        }
    }

    /* No Object Found */
    return null;
}