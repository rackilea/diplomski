MachinePauseTransitionManager manager = new MachinePauseTransitionManager();
Machine machineOne = ..
Machine machineTwo = ..

// creating pause transitions
manager.createPauseTransition(machineOne);
manager.createPauseTransition(machineTwo);
.
.
.
// when perticular machine logs in
manager.login(machineOne);
manager.login(machineTwo);