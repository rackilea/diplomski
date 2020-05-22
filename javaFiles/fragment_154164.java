public void setSurveyResponses(List<SurveyResponse> surveyResponses) {
    if (this.surveyResponses == null) {
        this.surveyResponses = surveyResponses;
    } else {
        this.surveyResponses.clear();
        if (surveyResponses != null) {
            this.surveyResponses.addAll(surveyResponses);
        }
    }
    if (this.surveyResponses != null) {
        for (SurveyResponse response : this.surveyResponses) {
            response.setParticipant(this);
        }
    }
}