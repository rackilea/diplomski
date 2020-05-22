class Question {
    static final String DEFAULT = "DefaultFollowup";
    String questionText;
    Map<String,Question> responsesAndFollowups;
    Question(String text) {
       this.questionText = text;
       responsesAndFollowups = new HashMap<String,Question>();
    }
    void addFollowup(String response, Question followup) {
        responsesAndFollowups.put(response,followup);
    }
    void setDefaultFollowup(Question followup) {
        addFollowup(DEFAULT,followup);
    }
    Question getFollowup(String response) {
        Question followup = responsesAndFollowups.get(response);
        if(followup == null) followup = responsesAndFollowups.get(DEFAULT);
        return followup;
    }
}