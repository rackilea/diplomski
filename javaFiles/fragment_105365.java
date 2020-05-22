public class QuestionDetails {

    private int questionId;
    private int englishLanguageId;
    private int spanishLanguageId;
    private String englishLanguageText;
    private String spanishLanguageText;

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public int getEnglishLanguageId() {
        return englishLanguageId;
    }

    public void setEnglishLanguageId(int englishLanguageId) {
        this.englishLanguageId = englishLanguageId;
    }

    public int getSpanishLanguageId() {
        return spanishLanguageId;
    }

    public void setSpanishLanguageId(int spanishLanguageId) {
        this.spanishLanguageId = spanishLanguageId;
    }

    public String getEnglishLanguageText() {
        return englishLanguageText;
    }

    public void setEnglishLanguageText(String englishLanguageText) {
        this.englishLanguageText = englishLanguageText;
    }

    public String getSpanishLanguageText() {
        return spanishLanguageText;
    }

    public void setSpanishLanguageText(String spanishLanguageText) {
        this.spanishLanguageText = spanishLanguageText;
    }

    @Override
    public String toString() {
        return new StringBuilder().append("questionId: ").append(questionId)
                .append(" ,englishLanguageId: ").append(englishLanguageId)
                .append(" ,englishLanguageText: ").append(englishLanguageText)
                .append(" ,spanishLanguageId: ").append(spanishLanguageId)
                .append(" ,spanishLanguageText: ").append(spanishLanguageText)
                .toString();
    }
}