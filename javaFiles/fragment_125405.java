long lastEvent;

ActionListener taskPerformer = new ActionListener() {
            public void doCalc(ActionEvent evt) {
                if ( (lastEvent + 1000) < System.currentTimeMillis() ) {
                   hardcoreCalculationTask();
                } else {
                  // this can be timed better
                  new Timer(1000, taskPerformer).start();
                }
            }
        };
}