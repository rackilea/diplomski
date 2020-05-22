Stage firstStage = ... ;

Stage secondStage = new Stage();

// secondStage.initOwner(firstStage);
firstStage.addEventHandler(WindowEvent.WINDOW_HIDDEN, evt -> secondStage.hide());

// ...