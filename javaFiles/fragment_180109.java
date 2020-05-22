private boolean finishedUpToMe() {
    for(int i = 0; i < id; i++) {
        final Boolean threadDone = threadIsDone.get(i);
        if (threadDone != null && !threadDone)
            return false;
    }
    return true;
}