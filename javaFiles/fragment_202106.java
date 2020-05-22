performTransaction() {
    doWSCall();
    // no need to worry about WS call exception, because DB call won't happen
    try {
        doDbCall()
    } catch (Exception ex) {
        rollbackWSCall()
        // rethrow ex
    }
}