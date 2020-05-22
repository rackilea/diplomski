boolean isDebugEnabled = log.isDebugEnabled();

while(cond) {
    if (isDebugEnabled) {
        log.debug(...);
    }
    doStuff();
}