interface TimeService {
    public long currentTimeMS();
}

// used when running the program in production.
enum VanillaTimeService implements TimeService {
    INSTANCE;
    public long currentTimeMS() { return System.currentTimeMS(); }
}

// used in testing.
class FixedTimeService implements TimeService {
    private long currentTimeMS = 0;
    public void currentTimeMS(long currentTimeMS) { this.currentTimeMS = currentTimeMS; }
    public long currentTimeMS() { return currentTimeMS; }
}