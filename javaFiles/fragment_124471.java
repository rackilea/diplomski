int user_id = 0;

Service<Boolean> turnPollService = new Service<Boolean>() {
    @Override
    protected Task<Boolean> createTask() {
        return new Task<Boolean>() {
            @Override
            protected Boolean call()
            throws InterruptedException {

                updateValue(true);

                String gamePin = Context.getContext().getGamePin();

                while (!GameConnection.yourTurn(user_id, gamePin)) {
                    Thread.sleep(5000);

                    if (TurnPolling.closedGame){
                        break;
                    }
                }

                return false;
            }
        };
    }
};

playerButton.disableProperty().bind(turnPollService.valueProperty());
refreshButton.disableProperty().bind(turnPollService.valueProperty());

refreshButton.textProperty().bind(
    Bindings.when(
        turnPollService.valueProperty().isEqualTo(true))
        .then("Waiting for your turn\u2026")
        .otherwise("Refresh"));