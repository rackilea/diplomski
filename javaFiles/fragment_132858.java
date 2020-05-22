FeedbackPanel feedbackPanel = new FeedbackPanel("feedbackPanelWartung") {
    @Override
    public String getMarkupId() {
        return "feedbackPanelWartung." + someUniqueValuePassedToThePanel;
    }
};
feedbackPanel.setOutputMarkupId(true);