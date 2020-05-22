public LocalDateTime establish() {
    if (!connectionEstablished) { // add this check
        startTime = LocalDateTime.now();
    }
    connectionEstablished = true;

    return startTime;
}