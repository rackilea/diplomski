btnDemo1.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
    @Override
    public void handle(ActionEvent actionEvent) {
        runDemoPrimaryReaction();
    }
});

btnDemo1.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
    @Override
    public void handle(ActionEvent actionEvent) {
        runDemoSecondaryReaction();
    }
});