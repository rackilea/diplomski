private void processTrain() throws IOException {
    final String strMode = getArg("mode");
    final String strMinutes = getArg("minutes");
    final String strStrategyError = getArg("strategyerror");
    final String strStrategyCycles = getArg("strategycycles");

    System.out.println("Training Beginning... Output patterns="
            + this.outputCount);

    final double strategyError = Double.parseDouble(strStrategyError);
    final int strategyCycles = Integer.parseInt(strStrategyCycles);

    final ResilientPropagation train = new ResilientPropagation(this.network, this.training);
    train.addStrategy(new ResetStrategy(strategyError, strategyCycles));

    if (strMode.equalsIgnoreCase("gui")) {
        TrainingDialog.trainDialog(train, this.network, this.training);
    } else {
        final int minutes = Integer.parseInt(strMinutes);
        EncogUtility.trainConsole(train, this.network, this.training,
                minutes);
    }
    System.out.println("Training Stopped...");
}