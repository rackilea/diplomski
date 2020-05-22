public class Schedule {
    private final Calendar showingTimestamp;

    public Schedule(Calendar showingTimestamp) {
        this.showingTimestamp = showingTimestamp;
    }

    public Calendar getShowingTimestamp() {
        return showingTimestamp;
    }

    public int getShowingWeekday() {
        return showingTimestamp.get(Calendar.DAY_OF_WEEK);
    }

}