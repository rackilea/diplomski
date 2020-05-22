// Build source
TimeSource source = null;
if (alternate) {
    source = new AlternateTimeSource();
}
else {
    source = new SystemTimeSource();
}

// Configure timer
SourcedTimerThread t = new SourcedTimerThread(source,new TimerTask() {
    @Override
    void run() {
        System.out.println("Yay!");
    }
}, delayMs, periodMs);

// Drive timer if necessary
if (alternate) {
    // Drive timer based on alternate source such as data
    source.setTime(dataRecord.getTime());
}

// When ready to cleanup
t.cancel();