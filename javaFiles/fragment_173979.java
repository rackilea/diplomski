@ManagedBean
@ApplicationScoped
public class Data {

    private static final Map<Long, String> STATUSES = createStatuses();

    private static Map<Long, String> createStatuses() {
        Map<Long, String> statuses = new HashMap<Long, String>();
        statuses.put(1L, "New");
        statuses.put(2L, "Rejected");
        statuses.put(5L, "Cancelled");
        return Collections.unmodifiableMap(statuses);
    }

    public Map<Long, String> getStatuses() {
        return STATUSES;
    }

}