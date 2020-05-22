public final class ImmutableReminder{
    private final Date remindingDate;

    public ImmutableReminder (Date remindingDate) {
        long incomingTime = remindingDate.getTime()

        if(incomingTime < System.currentTimeMillis()){
            throw new IllegalArgumentException("Can not set reminder” +
                        “ for past time: " + remindingDate);
        }
        this.remindingDate = new Date(incomingTime);
    }

    public Date getRemindingDate() {
        return (Date) remindingDate.clone();
    }
}