@Component
public class customTrace implements TraceRepository {

    private final TraceRepository lastOneHundretLogs = new InMemoryTraceRepository();


    @Override
    public List<Trace> findAll() {
        return null;
    }

    @Override
    public void add(Map<String, Object> map) {       

    }
}