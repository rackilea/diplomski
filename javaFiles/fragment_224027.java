public interface Day {
    public void doSomething();
}

public enum WorkDay implements Day {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY;

    @Override
    public void doSomething() {
        // do some work
    }
}

public enum WeekEnd implements Day {
    SATURDAY,
    SUNDAY;

    @Override
    public void doSomething() {
        // have fun
    }
}