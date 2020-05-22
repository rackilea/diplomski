Transition transition;
// Set up your transition or animation
transition = buildTransition();
// Show your processing screen within the transition
showProcessingScreen();
transition.setOnFinished(new EventHandler<ActionEvent>() {
    @Override
    public void handle(ActionEvent arg0) {
        Report.findAppliedJars();
        mainApp.showReportingScreen();
    }       
});