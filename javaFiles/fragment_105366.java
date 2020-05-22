List<QuestionDetails> questionsList = new ArrayList<>();
List<QuestionText> questionTextList = questionManager
        .getQuestionsTextByQuestionId(Long.parseLong(questions
                .getQuestionId().toString()));
for (QuestionText questionText : questionTextList) {
    /* Get QuestionDetails Object */
    QuestionDetails qd = getQuestionDetails(
            questionText.getQuestionId(), questionsList);
    /* Check Null */
    if(null == qd) {
        /* Get New Object */
        qd = new QuestionDetails();
        /* Add Object To List */
        questionsList.add(qd);
    }
    /* Set Question ID */
    qd.setQuestionId(questionText.getQuestionId());
    /* Set Language ID & Text */
    if (questionText.getLanguageId().longValue() == 1) {
        qd.setEnglishLanguageId(questionText.getLanguageId()
                .longValue());
        qd.setEnglishLanguageText(questionText.getQuestionText());
    } else {
        qd.setSpanishLanguageId(questionText.getLanguageId()
                .longValue());
        qd.setSpanishLanguageText(questionText.getQuestionText());
    }
}
adminCollectionBookendModel.put("questionListMap", questionsList);