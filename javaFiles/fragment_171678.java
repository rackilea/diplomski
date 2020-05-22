public class Synchronizer extends UntypedActor {
    private final Long taskLogId;
    private final String clientGroup;
    private final boolean messagesOnly;
    private final String notes;

    // Factory method
    public static Props props(Long taskLogId, String clientGroup, boolean messagesOnly, String notes) {
        return Props.create(Synchronizer.class, taskLogId, clientGroup, messagesOnly, notes);
    }

    public Synchronizer(Long taskLogId, String clientGroup, boolean messagesOnly, String notes) {
        this.taskLogId= taskLogId;
        this.clientGroup= clientGroup;
        this.messagesOnly= messagesOnly;
        this.notes= notes;
    }
    @Override
    public void onReceive(Object message) throws Exception {
        ...
    }
}