private int compareTrials(String trial, String current, int startIndex) {
    int nextIndex = current.indexOf(trial, startIndex);
    if(nextIndex == -1) {
        return 0;
    }
    return 1 + compareTrials(trial, current, nextIndex + trial.length());
}