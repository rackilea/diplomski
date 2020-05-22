public void tryStartProgressOnThisTaskIfAllowed() {
    tryStopTaskInProgressIfAllowed()

    if (!isTaskInProgress()) {
        tryStartProgressOnThisTask();
    }
}

private void tryStopTaskInProgressIfAllowed() {
    if (!isTaskInProgress()) {
        return;
    }


    TaskInProgressResult result = whatToDoWithTaskInProgress();
    if (result == Result.KEEP) {
        return;
    } else if (result == Result.DROP)
        tryDropTaskInProgress();
    } else if (result == Result.SAVE) {
        trySaveTaskInProgress();
    }
}