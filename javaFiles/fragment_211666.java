Table actionTable = new Table();
    //position the table outside the screen
    actionTable.setPosition(stage.getWidth(), 0); //Position on the right of the stage

    MoveToAction moveAction = new MoveToAction();
    moveAction.setPosition(0, 0); //Move from right side of stage inside the stage
    moveAction.setDuration(.5f); //Duration of this action
    moveAction.setInterpolation(Interpolation.fade); //Fade the movement in and out, many interpolations are supplied by the framework.

    actionTable.addAction(moveAction); //Execute Action.