public class CheckInSummary {

    private int workingHours;
    private boolean inProgress;
    private String day;

    public void accept(CheckIn checkIn) {
        workingHours += checkIn.workingHours;
        inProgress = inProgress || checkIn.inProgress;
        day = checkIn.day;
    }

    public CheckInSummary combine(CheckInSummary summary) {
        workingHours += summary.workingHours;
        inProgress = inProgress || summary.inProgress;
        return this;
    }

    public CheckIn finish() {
        return new CheckIn(day, workingHours, inProgress);
    }

}