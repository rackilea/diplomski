public void chargeI18nValues() {
    loadTab.setText(SolverAssistant.messages.getString("LoadLog"));
    editTab.setText(SolverAssistant.messages.getString("EditLog"));
    barTabPageLoadController.chargeI18nValues();
    barTabPageEditController.chargeI18nValues();
}