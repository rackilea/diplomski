public class Synchronizer extends UntypedActor {
    private final Long taskLogId;
    private final String clientGroup;
    private final boolean messagesOnly;
    private final String notes;

    @Inject
    public Synchronizer(@Assisted Long taskLogId, @Assisted("clientGroup") String clientGroup, @Assisted boolean messagesOnly, @Assisted("notes") String notes) {
        this.taskLogId= taskLogId;
        this.clientGroup= clientGroup;
        this.messagesOnly= messagesOnly;
        this.notes= notes;
    }
    @Override
    public void onReceive(Object message) throws Exception {
        ...
    }
    // The factory
    public interface Factory {
        public Actor create(Long taskLogId, String clientGroup, boolean messagesOnly, String notes);
    }
}